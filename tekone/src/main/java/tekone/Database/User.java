package tekone.Database;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType; 
import javax.persistence.GeneratedValue; 
import javax.persistence.Id;
import javax.persistence.Table; 

@Entity
@Table
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id) {
        this.id = id;
    }
    
}
