package users;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
public class Bruker implements Serializable{
    @Id
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String fName;
    @Column 
    private String lName;
  


    public Bruker(String email, String password, String fName, String lName) {
        this.email = email;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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
    

    protected Bruker(){
    }
}