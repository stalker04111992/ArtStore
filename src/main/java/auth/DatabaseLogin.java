package auth;

import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;
import services.HashPassword;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import javax.sql.DataSource;
import java.io.IOException;
import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseLogin implements LoginModule {

    protected SimpleGroup group = new SimpleGroup("Roles");
    protected char[]credential;
    protected Subject subject;
    protected CallbackHandler callbackHandler;
    protected Map sharedState;
    protected Map options;
    protected Principal principal;
    protected boolean loginOk = false;
    protected int id;
    protected String username;
    protected String password;

    public void initialize(Subject subject, CallbackHandler callbackHandler,Map sharedState, Map options){
        this.sharedState = sharedState;
        this.options = options;
        this.callbackHandler = callbackHandler;
        this.subject = subject;
    }

    private Connection getConnection() throws NamingException, SQLException{
        //create initial context
        InitialContext ctx = new InitialContext();
        DataSource dataSource = (DataSource) ctx.lookup("java:/jboss/datasources/mysqldb");
        //get connection
        return dataSource.getConnection();
    }

    //get ResultSetUsers
    private ResultSet resultSet (String username)throws SQLException, NamingException{
        Connection connection = getConnection();
        //get statement
        PreparedStatement statement = connection.prepareStatement("SELECT id, password, enabled FROM users where username=?");
        statement.setString(1, username);
        //execute query
        return statement.executeQuery();
    }

    //get ResultSetRoles
    private ResultSet resultSetRoles (int id)throws SQLException, NamingException{
        Connection connection = getConnection();
        //get statement
        PreparedStatement statement = connection.prepareStatement("SELECT role FROM roles where userID=?");
        statement.setString(1, Integer.toString(id));
        //execute query
        return statement.executeQuery();
    }

    public boolean login() throws LoginException
    {
        try {
            //request = (HttpServletRequest) PolicyContext.getContext(HttpServletRequest.class.getName());
            username = getUsernameAndPassword()[0];
            password = getUsernameAndPassword()[1];
            //if null
            if (username == null || password == null){
                throw new NullPointerException();
            }
            //get result set
            ResultSet rs = resultSet(username);
            String databasePassword = null;
            while (rs.next()){
                databasePassword = rs.getString("password");
                id = rs.getInt("id");
            }
            if (databasePassword == null){
                throw new NullPointerException();
            }
            String hashPassword = HashPassword.getHashPassword(username, password);
            if (hashPassword == null){
                throw new NullPointerException();
            }
            if (databasePassword.equals(hashPassword)){
                Callback[] calls = new Callback[2];
                calls[0] = new NameCallback(username);
                calls[1] = new PasswordCallback(password, true);
                hashMap("javax.security.auth.login.name", username);
                hashMap("javax.security.auth.login.password", password);
                callbackHandler.handle(calls);
                loginOk = true;
                return true;
            }
            else{
                throw new LoginException();
            }
        }
        catch (Exception exception){
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    private void hashMap(String key, String value){
        sharedState.put(key, value);
    }

    public boolean abort() throws LoginException{
        username = null;
        principal = null;
        subject = null;
        group = null;
        return true;
    }

    public boolean commit()throws LoginException{
        try{
            if (loginOk){
                ResultSet rs = resultSetRoles(id);
                while (rs.next()){
                    String role = rs.getString("role");
                    principal = new SimplePrincipal(role);
                    group.addMember(principal);
                }
                subject.getPrincipals().add(new SimplePrincipal(username));
                subject.getPrincipals().add(group);
            }
            return true;
        }
        catch (Exception exeption){
            exeption.printStackTrace();
            throw new LoginException(exeption.getMessage());
        }
    }

    public boolean logout() throws LoginException {
        if (loginOk){
            subject.getPrincipals().remove(new SimplePrincipal(username));
            subject.getPrincipals().remove(group);
            username = null;
            group = null;
            loginOk = false;
        }
        return true;
    }

    protected String[] getUsernameAndPassword() throws LoginException{
        String[] info = {null, null};
        // prompt for a username and password
        if( callbackHandler == null ){
            throw new LoginException("Error: no CallbackHandler available " +
                    "to collect authentication information");
        }
        NameCallback nc = new NameCallback("User name: ", "guest");
        PasswordCallback pc = new PasswordCallback("Password: ", false);
        Callback[] callbacks = {nc, pc};
        String username;
        String password = null;
        try{
            callbackHandler.handle(callbacks);
            username = nc.getName();
            char[] tmpPassword = pc.getPassword();
            if( tmpPassword != null){
                credential = new char[tmpPassword.length];
                System.arraycopy(tmpPassword, 0, credential, 0, tmpPassword.length);
                pc.clearPassword();
                password = new String(credential);
            }
        }
        catch(IOException ioe){
            throw new LoginException(ioe.toString());
        }
        catch(UnsupportedCallbackException uce){
            throw new LoginException("CallbackHandler does not support: " + uce.getCallback());
        }
        info[0] = username;
        info[1] = password;
        return info;
    }
}