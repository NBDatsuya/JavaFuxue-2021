public class Lesson {
    private int id;
    private String name;
    private String type;

    public Lesson(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public String toString() {
        return "Lesson{id=" + id + ", name=" + name + ", type=" + type + "}";
    }
}
