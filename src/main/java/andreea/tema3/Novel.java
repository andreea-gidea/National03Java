package andreea.tema3;

public class Novel extends Book {
    private String type;

    public Novel(String name, int numberOfPages, String type) {
        super(name, numberOfPages);
        this.type = type;
    }

    public Novel(String name, int numberOfPages) {
        super(name, numberOfPages);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return " Novel{" +
                "name='" + getName() + '\'' +
                "numberOfPages='" + getNumberOfPages() + '\'' +
                "type='" + type + '\'' +
                '}';
    }
}
