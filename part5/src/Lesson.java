public class Lesson {
    private int id;
    private String name;
    private String type;

    private Test test;

    public Lesson(int id, String name, String type, Test test) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Test getTest() {
        return test;
    }

    public String toString() {
        return "Lesson{id=" + id + ", name=" + name + ", type=" + type + "}";
    }
}
