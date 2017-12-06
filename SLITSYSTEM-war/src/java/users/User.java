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
    @Column
    private String fName;
    @Column
    private String lName;


    public User(String email, String password, String fName, String lName) {
        this.email = email;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
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
    
    public String getFName() {
        return fName;
    }
    
    public void setFName(String fName) {
        this.fName = fName;
    }
    
    public String getLName() {
        return lName;
    }
    
    public void setLName(String lName) {
        this.lName = lName;
    }
    
    
}