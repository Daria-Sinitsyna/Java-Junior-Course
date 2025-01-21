import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "information.journal")

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "specialization")
    private String specialization;
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    public Person(String lastname, String firstname, String specialization, LocalDate dateOfBirth) {

        this.lastname = lastname;
        this.firstname = firstname;
        this.specialization = specialization;
        this.dateOfBirth = dateOfBirth;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", specialization='" + specialization + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
