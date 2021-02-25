package andreea.tema6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Hobby {
    private String nameOfHobby;
    private int frequency;
    private List<Address> addresses= new ArrayList<>();

    public Hobby(String nameOfHobby, int frequency) {
        this.nameOfHobby = nameOfHobby;
        this.frequency = frequency;

    }
    public void addAddress (Address address){
        this.addresses.add(address);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Hobby  ");
        result.append(nameOfHobby);
        result.append(",  Practiced in {");
        for (Address a : addresses) {
            result.append(a.toString());
        }
        result.append("}");
        return result.toString();

    }
}
