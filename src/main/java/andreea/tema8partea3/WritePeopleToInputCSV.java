package andreea.tema8partea3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class WritePeopleToInputCSV {
    static BufferedWriter writer;
    public static void main(String[] args) throws IOException {

        System.out.println("First writing in CSV");


        List<Person> people = new ArrayList<>();

        Person person1 = new Person("Alisa" , "Iliescu" , LocalDate.of(1980 , Month.APRIL, 20));
        Person person2 = new Person("George" , "Matei" , LocalDate.of(1980 , Month.APRIL, 13));
        Person person3 = new Person("Dorel" , "Maftei" , LocalDate.of(1990 , Month.JANUARY, 23));
        Person person4 = new Person("Carmen" , "Salciua" , LocalDate.of(1988 , Month.FEBRUARY, 13));
        Person person5 = new Person("Georgeta" , "Amariei" , LocalDate.of(1980 , Month.MARCH, 13));
        Person person6 = new Person("Nicusor" , "Nastase" , LocalDate.of(1970 , Month.APRIL, 17));
        Person person7 = new Person("Nicolae" , "Lupu" , LocalDate.of(1980 , Month.MAY, 27));
        Person person8 = new Person("Maria" , "Enescu" , LocalDate.of(1980 , Month.JULY, 11));
        Person person9 = new Person("Ghita" , "Lupu" , LocalDate.of(1989 , Month.JUNE, 15));
        Person person10 = new Person("Sanda" , "Petrescu" , LocalDate.of(2000 , Month.AUGUST, 16));
        Person person11 = new Person("Lola" , "Gregoriu" , LocalDate.of(1984 , Month.DECEMBER, 16));
        Person person12 = new Person("Vicentiu" , "Calin" , LocalDate.of(1985 , Month.APRIL, 17));
        Person person13 = new Person("Carmen" , "Cretu" , LocalDate.of(1976 , Month.DECEMBER, 17));
        Person person14 = new Person("Oana" , "Roman" , LocalDate.of(1994 , Month.NOVEMBER, 15));
        Person person15 = new Person("Gheorghe" , "Gheorghiu" , LocalDate.of(1995 , Month.NOVEMBER, 1));
        Person person16 = new Person("Greta" , "Garbo" , LocalDate.of(1980 , Month.FEBRUARY, 1));
        Person person17 = new Person("Cecilia" , "Marcu" , LocalDate.of(1986 , Month.MARCH, 5));
        Person person18 = new Person("Simona" , "Sevda" , LocalDate.of(1981 , Month.OCTOBER, 7));
        Person person19 = new Person("Ana" , "Monet" , LocalDate.of(1982 , Month.OCTOBER, 8));
        Person person20 = new Person("Mona" , "Rafie" , LocalDate.of(1970 , Month.DECEMBER, 8));
        Person person21 = new Person("Alisa" , "Iliesca" , LocalDate.of(1975 , Month.APRIL, 10));

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);
        people.add(person7);
        people.add(person8);
        people.add(person9);
        people.add(person10);
        people.add(person11);
        people.add(person12);
        people.add(person13);
        people.add(person14);
        people.add(person15);
        people.add(person16);
        people.add(person17);
        people.add(person18);
        people.add(person19);
        people.add(person20);
        people.add(person21);

        writer = getWriterInstance();

        writeHearer(writer);

        for (Person p : people) {
            writePerson(writer, p);
        }
        writer.flush();
        System.out.println("People written in csv. CSV ready to be read  ");

    }

    static BufferedWriter getWriterInstance() throws IOException {

        if (writer != null) {
            return writer;
        }
        return new BufferedWriter(new FileWriter(new File("src/main/resources/PeopleIn.csv")));
    }
    private static void writeHearer(BufferedWriter writer) {
        try {
            getWriterInstance().write("firstName,lastName,dateOfBirth");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Exception while writing header ");
        }
    }
    static void writePerson(BufferedWriter writer, Person person) {
        try {
            String line = person.getFirstName() + "," + person.getLastName() + "," + person.getDateOfBirth();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Exception while writing person " + person);
        }
    }

}
