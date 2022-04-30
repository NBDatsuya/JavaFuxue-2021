import java.util.*;

public class StudentDatabase implements DatabaseCountable, Iterable<Student> {
    private ArrayList<Student> students;
    private static StudentDatabase instance = null;

    private StudentDatabase() {
        students = new ArrayList<>();
    }

    ;

    public static StudentDatabase getInstance() {
        if (instance == null) {
            instance = new StudentDatabase();
        }
        return instance;
    }

    @Override
    public int getSize() {
        return students.size();
    }

    public Student getStudentById(int id) {
//        Iterator<Student> iterator = students.iterator();
//        while (iterator.hasNext()) {
//            Student student = ddq.next();
//            if (student.getId() == id) {
//                return student;
//            }
//        }
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(String name, String major) {
        int id = this.getSize() + 1;
        Student student = new Student(id, name, major);
        students.add(student);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}
