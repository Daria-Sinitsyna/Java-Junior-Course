import org.hibernate.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class Db {

    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void connect() {

        try {
            Connection con;
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = con.createStatement();
            statement.execute("DROP SCHEMA `information`");
            statement.execute("CREATE SCHEMA `information`");
            statement.execute("CREATE TABLE `information`.`journal` (`id` INT NOT NULL AUTO_INCREMENT, `lastname` VARCHAR(100) NULL," +
                    "`firstname` VARCHAR(100) NULL, `specialization` VARCHAR(100) NULL, `dateOfBirth` DATE, " +
                    "PRIMARY KEY(`id`));");

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        // ---------------- заполнение данными --------------------------------
        Connector connector = new Connector();
        Session session = connector.getSession();
        Person person = new Person("Ivanov", "Ivan", "Engineer", LocalDate.of(1990,
                12, 12));
        session.beginTransaction();
        session.save(person);
        person = new Person("Smirnov", "Ivan", "Research Engineer", LocalDate.of(1995,
                12, 12));
        session.save(person);
        person = new Person("Ivanova", "Anna", "Engineer", LocalDate.of(1993,
                11, 12));
        session.save(person);
        person = new Person("Sinitsyna", "Daria", "CEO", LocalDate.of(1990,
                01, 12));
        session.save(person);
        person = new Person("Sinitsyn", "Roman", "Secretary", LocalDate.of(1973,
                01, 12));
        session.save(person);
        session.getTransaction().commit();
        session.close();



    }

    public static void readData(){
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            List<Person> persons = session.createQuery("FROM Journal",
                    Person.class).getResultList();
            persons.forEach(b -> {
                System.out.println("All persons : " + b);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
