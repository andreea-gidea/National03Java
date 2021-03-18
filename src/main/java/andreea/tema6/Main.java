package andreea.tema6;


import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Oana", 23, "223567346");
        Person person2 = new Person("Luzia", 22, "323567345");
        Person person3 = new Person("Adrian", 26, "123567345");
        Person person4 = new Person("Bolovan", 25, "123567345");
        Person person5 = new Person("Radu", 21, "123567345");
        Person person6 = new Person("Radu", 24, "12562745");

        Comparator<Person> PersonComparatorByName = Comparator.comparing(person -> person.getName());
        Comparator<Person> PersonComparatorByAge = Comparator.comparing(person -> person.getAge());

        Set<Person> personSetByAge = new TreeSet<>(PersonComparatorByAge);
        personSetByAge.add(person1);
        personSetByAge.add(person2);
        personSetByAge.add(person3);
        personSetByAge.add(person4);
        personSetByAge.add(person5);
        personSetByAge.add(person6);

        System.out.println("Person set by age:");
        for (Person p : personSetByAge
        ) {
            System.out.println(p.toString());
        }
        Set<Person> personSetByName = new TreeSet<>(PersonComparatorByName);
        personSetByName.add(person1);
        personSetByName.add(person2);
        personSetByName.add(person3);
        personSetByName.add(person4);
        personSetByName.add(person5);
        personSetByName.add(person6);

        System.out.println("Person set by name:");
        for (Person p : personSetByName
        ) {
            System.out.println(p.toString());
        }

        Hobby ski = new Hobby("ski", 2);
        Address placeToSki1 = new Address("Romania", "Predeal", "Fagarasului", 23);
        Address placeToSki2 = new Address("Romania", "Brasov", "Poienii", 21);
        Address placeToSki3 = new Address("Austria", "Ceva", "Zaone", 25);

        person1.addHobby("1", ski);
        ski.addAddress(placeToSki1);
        ski.addAddress(placeToSki2);
        ski.addAddress(placeToSki3);
        System.out.println("There You GO   " + person1);


    }


}
