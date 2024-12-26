import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person person1 = new Person("Svetlana", LocalDate.of(1982, 12,01), null);
        Person person2 = new Person("Inna", LocalDate.of(1990, 12, 05), null);
        Person person3 = new Person("Oleg", LocalDate.of(1975, 9, 05), null);
        Person person4 = new Person("Denis", LocalDate.of(1992, 9, 05), null);

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

//        for(Person person : persons){
//            System.out.println(person);
//        }


        Path path = Path.of("resources", "persons.out");

//      writeObject(path, persons);



        FileInputStream stream = new FileInputStream((path.toFile()));

        try(ObjectInputStream objectInputStream = new ObjectInputStream(stream)){

            Person person;

            while(stream.available() > 0){
                person = (Person) objectInputStream.readObject();
                System.out.println(person);
            }

            }
        }



    public static void writeObject(Path path, List<Person> persons) throws IOException {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))){
            for(Person person : persons){
                System.out.println(person);
                objectOutputStream.writeObject(person);
            }
        }

    }
}
