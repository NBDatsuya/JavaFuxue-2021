import java.util.*;

public class LessonDatabase implements DatabaseCountable {
    private ArrayList<Lesson> lessons;
    private static LessonDatabase instance = null;

    private LessonDatabase() {
        lessons = new ArrayList<>();
    }

    ;

    public static LessonDatabase getInstance() {
        if (instance == null) {
            instance = new LessonDatabase();
        }
        return instance;
    }

    @Override
    public int getSize() {
        return lessons.size();
    }

    public Lesson getStudentById(int id) {
//        Iterator<Lesson> iterator = lessons.iterator();
//        while (iterator.hasNext()) {
//            Lesson lesson = ddq.next();
//            if (lesson.getId() == id) {
//                return lesson;
//            }
//        }
        for (Lesson lesson : lessons) {
            if (lesson.getId() == id) {
                return lesson;
            }
        }
        return null;
    }

    public ArrayList<Lesson> getStudents() {
        return lessons;
    }

    public void addLesson(String name, String type, Test test) {
        int id = this.getSize() + 1;
        Lesson lesson = new Lesson(id, name, type);
        lessons.add(lesson);
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

}
