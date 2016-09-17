import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chaikaam on 17.09.16.
 */

@Entity
@Table(name = "Students")
public class Student implements Serializable{

    public Student() {
    }

    @Id
    @Column
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    private String name;

    @Column
    private Long groupID;

    public Student(String name, Long groupID) {
        this.name = name;
        this.groupID = groupID;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + groupID;
    }
}
