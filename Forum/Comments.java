package Forum;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comments implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private int CommentID;
    @Column
    private String QuestionComment;
    @Column
    private String KommentarNavn;
    @Column
    private String QuestionID;

    public Comments(String QuestionComment, String KommentarNavn, String QuestionID) {
        this.QuestionComment = QuestionComment;
        this.KommentarNavn = KommentarNavn;
        this.QuestionID = QuestionID;
    }

    public String getQuestionComment() {
        return QuestionComment;
    }

    public void setQuestionComment(String QuestionComment) {
        this.QuestionComment = QuestionComment;
    }
    
    public int getCommentID(){
        return CommentID;
    }
    
    public void setCommentID(int CommentID) {
        this.CommentID = CommentID;
    }
    
    public String getKommentarNavn() {
        return KommentarNavn;
    }
    
    public void setKommentarNavn(String KommentarNavn) {
        this.KommentarNavn = KommentarNavn;
    }
    
    public  String QuestionID(){
        return QuestionID;
    }
    
    public void setQuestionID(String QuestionID) {
        this.QuestionID = QuestionID;
    }

    protected Comments() {
    }

}
