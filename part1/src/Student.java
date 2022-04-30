import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private String type;
    private ArrayList<Lesson> lessons;

    public Student(int id, String name, String type){
        this.id = id;
        this.name = name;
        this.type = type;
        this.lessons = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public ArrayList<Lesson> getLessons(){
        return lessons;
    }

    public void addLesson(Lesson lesson){
        lessons.add(lesson);
    }

    public void withdrawLesson(Lesson lesson){
        lessons.remove(lesson);
    }

}
