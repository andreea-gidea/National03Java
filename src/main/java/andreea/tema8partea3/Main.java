package andreea.tema8partea3;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    static BufferedWriter writer;
    public static void main(String[] args) throws IOException {


        String[] arguments = new String[] {};
        WritePeopleToInputCSV.main(arguments);

        String separator = File.separator;
        String urlToResources = "src" + separator + "main" + separator + "resources" + separator;
        File file = new File(urlToResources+"PeopleIn.csv");
        File fileOut = new File(urlToResources+"PeopleOut.csv");

       writePeopleBornInMonth(file , Month.APRIL, fileOut);

    }


    public static List<Person> getCollectOfPeopleWithBirthdayInMonth(File file, Month month) throws IOException {
        return Files.readAllLines(file.toPath())
                .stream()
                .skip(1)
                .filter(s -> StringUtils.isNotBlank(s))
                .map(Main::readPeopleFromCSV)
                .filter(p -> p.getDateOfBirth().getMonth()==month)
                .sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName))
                .collect(Collectors.toList());
    }

    public static Person readPeopleFromCSV(String line) {
        String[] fields = line.split(",");
        return Person.builder()
                .firstName(fields[0])
                .lastName(fields[1])
                .dateOfBirth(LocalDate.parse(fields[2]))
                .build();
    }
    static void writePerson(BufferedWriter writer, Person person) {
        try {
            String line = person.getFirstName() + "," + person.getLastName();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Exception while writing person " + person);
        }
    }

    static void writePeopleBornInMonth (File file, Month month , File fileOut) throws IOException {
        List<Person> people = getCollectOfPeopleWithBirthdayInMonth(file , month);
        writer = getWriterInstance(fileOut);
        for (Person p :people){
            writePerson(writer,p);
        }
        writer.flush();
        System.out.println("People written in output File");

    }

//    static void writePeopleBornInMonth(File file, Month month , File fileOut) throws IOException {
//        writer=getWriterInstance(fileOut);
//        List<Person> people = getCollectOfPeopleWithBirthdayInMonth(file,month);
//        for (Person p : people) {
//            try {
//                String line = p.getFirstName() + "," + p.getLastName();
//                writer.write(line);
//                writer.newLine();
//            } catch (IOException e) {
//                System.err.println("Exception while writing person " + p);
//            }writer.flush();
//        }
//    }
    static BufferedWriter getWriterInstance(File file) throws IOException {
        if (writer != null) {
            return writer;
        }
        return new BufferedWriter(new FileWriter(new File(String.valueOf(file))));
    }
}
