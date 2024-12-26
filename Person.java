import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;

public class Person implements Serializable {

    private static final long serialVersionUID = 25L;
    private String name;
    private LocalDate dateofBirth;
    private LocalDate dateOfDeath;

    public Person(String name, LocalDate dateofBirth, LocalDate dateOfDeath) {
        this.name = name;
        this.dateofBirth = dateofBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public int returnAge(LocalDate dateofBirth, LocalDate dateOfDeath){
        if(dateOfDeath == null){
            dateOfDeath = LocalDate.now();
        }
        return Period.between(dateofBirth, dateOfDeath).getYears();
    }

    @Override
    public String toString() {
        return "Person: " +
                "name: " + name +
                ", Birthday: " + dateofBirth +
                ", Age: " + returnAge(dateofBirth, dateOfDeath) + " year(s)";
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

}
