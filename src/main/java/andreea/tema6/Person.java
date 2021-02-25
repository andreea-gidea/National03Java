package andreea.tema6;


import java.util.*;

public class Person  {

    private String name;
    private int age;
    private String CNP;

    private Map <String, Hobby> listOfHobbyes = new HashMap <>();

    public Person()  {
    }

    public Person(String name, int age, String CNP) {
        this.name = name;
        this.age = age;
        this.CNP = CNP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void addHobby(String nrCrt, Hobby h) {
        this.listOfHobbyes.putIfAbsent(nrCrt,h);
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", listOfHobbyes=" + listOfHobbyes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(CNP, person.CNP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CNP);
    }
}
