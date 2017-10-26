package users;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable{
    @Id
    @Column
    private String email;
    @Column
    private String password;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    protected User(){
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}