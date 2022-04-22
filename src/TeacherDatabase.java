import java.util.*;

public class TeacherDatabase implements DatabaseCountable {
    private ArrayList<Teacher> teachers;
    private static TeacherDatabase instance = null;

    private TeacherDatabase() {
        teachers = new ArrayList<>();
    }

    ;

    public static TeacherDatabase getInstance() {
        if (instance == null) {
            instance = new TeacherDatabase();
        }
        return instance;
    }

    public Teacher getTeacherById(int id) {
//        Iterator<Teacher> iterator = teachers.iterator();
//        while (iterator.hasNext()) {
//            Teacher teacher = ddq.next();
//            if (teacher.getId() == id) {
//                return teacher;
//            }
//        }
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    @Override
    public int getSize() {
        return teachers.size();
    }

    public void addTeacher(String name, String phoneNumber) {
        int id = this.getSize() + 1;
        Teacher teacher = new Teacher(id, name, phoneNumber);
        teachers.add(teacher);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
}
