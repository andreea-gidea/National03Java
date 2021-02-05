package andreea.tema6;


public class Person implements Comparable <Person>{

    private String name;
    private int age;

    public Person()  {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public int compareTo(Person o2) {

        if (this.getAge() < o2.getAge()){
            return 1;
        }
        if (this.getAge() > o2.getAge()){
            return -1;
        }

        return this.getName().compareTo(o2.getName());
    }
}
