
package Module;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class ModuleOppgave implements Serializable{
    @Id
    @Column
    private String navn;
    @Column
    private String fag;
    @Column
    private String publisertAv;
    @Column 
    private String deadline;

    public ModuleOppgave(String navn, String fag, String publisertAv, String deadline) {
        this.navn = navn;
        this.fag = fag;
        this.publisertAv = publisertAv;
        this.deadline = deadline;
    }
    

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getFag() {
        return fag;
    }

    public void setFag(String fag) {
        this.fag = fag;
    }

    public String getPublisertAv() {
        return publisertAv;
    }

    public void setPublisertAv(String publisertAv) {
        this.publisertAv = publisertAv;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}


