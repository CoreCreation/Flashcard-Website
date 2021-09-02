package net.corecreationstudios.flashcard.flashcard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Flashcard {
    @Id
    @SequenceGenerator(
        name = "flashcard_sequence",
        sequenceName = "flashcard_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "flashcard_sequence"
    )

    private Long id;
    private String front;
    private String back;

    public Flashcard() {

    }

    public Flashcard(Long id, String front, String back){
        this.id = id;
        this.front = front;
        this.back = back;
    }

    public Flashcard(String front, String back){
        this.front = front;
        this.back = back;
    }
    
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFront(){
        return front;
    }
    public void setFront(String front){
        this.front = front;
    }

    public String getBack(){
        return back;
    }

    public void setBack(String back){
        this.back = back;
    }
    
    @Override
    public String toString() {
        return "Flashcard{id=" + id + ", front=" + front + ", back=" + back + "}";
    }
}
