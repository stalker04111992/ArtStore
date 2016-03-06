package entities;

import javax.persistence.*;

@Entity(name="users")
@Table(name="users")
public class User
{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Column(name = "password", nullable = false, length = 40)
    private String password;
    @Column(name = "enabled", nullable = false)
    private int enabled;
    @Column(name = "email", nullable = false, length = 50)
    private String email;


    public User(){}

    public User(String username, String password, int enabled, String email)
    {
        this.username = username;
        this.password = password;
        this.setEnabled(enabled);
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
