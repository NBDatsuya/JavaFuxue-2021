import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SchoolSystem {

    private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter stdOut = new PrintWriter(System.out, true);
    private static PrintWriter stdErr = new PrintWriter(System.err, true);

    private StudentDatabase studentDatabase;
    private TeacherDatabase teacherDatabase;
    private LessonDatabase lessonDatabase;

    public static void main(String[] args) {
        SchoolSystem application = new SchoolSystem();
        application.run();
    }

    private SchoolSystem() {
        this.studentDatabase = StudentDatabase.getInstance();
        this.teacherDatabase = TeacherDatabase.getInstance();
        this.lessonDatabase = LessonDatabase.getInstance();
    }

    public void run() {
        setupDatabase();

        stdOut.println("Welcome to the school system!");

        while (true) {
            int option = displayAndGetOptions();

            switch (option) {
                case 1:
                    // Student management
                    StudentManagement();
                    break;
                case 2:
                    // Teacher management
                    TeacherManagement();
                    break;
                case 3:
                    // Lesson management
                    LessonManagement();
                    break;
                case 4:
                    // Exit system
                    stdOut.println("Thank you for using the school system!");
                    System.exit(0);
                    break;
            }
        }

    }

    private void setupDatabase() {

    }

    private int getChoice(int min, int max) {
        while (true) {

            stdOut.println();
            stdOut.print("\n>Enter your choice: ");
            stdOut.flush();

            try {
                int input = Integer.parseInt(stdIn.readLine());
                if (input >= min && input <= max) {
                    return input;
                }
                stdErr.println("Invalid input. Please try again.");
                stdErr.flush();
            } catch (IOException e) {
                stdErr.println("Invalid input, please try again.");
                stdErr.flush();
            }
        }
    }

    private int displayAndGetOptions() {

        stdOut.println("Please select an option:");
        stdOut.print("[1] Student Management\n" +
                "[2] Teacher Management\n" +
                "[3] Lesson Management\n" +
                "[4] Exit System");
        stdOut.flush();

        return getChoice(1, 4);
    }

    private void StudentManagement() {
        stdOut.println("Student Management");
        while (true) {
            stdOut.println();
            stdOut.println("There is " + studentDatabase.getSize() + " student(s) in the database.");
            stdOut.println("-----------------");
            stdOut.print("[1] Add Student\n" +
                    "[2] Deposit Lesson for Student\n" +
                    "[3] Withdraw Lesson for Student\n" +
                    "[4] View Student Details\n" +
                    "[5] Show All Students\n" +
                    "[6] Back");
            stdOut.flush();

            int option = getChoice(1, 6);

            switch (option) {
                case 1:
                    // Add Student
                    addStudent();
                    break;
                case 2:
                    // Deposit Lesson for Student
                    depositLesson(getStudent());
                    break;
                case 3:
                    // Withdraw Lesson for Student
                    withdrawLesson(getStudent());
                    break;
                case 4:
                    // View Student Details
                    showStudentDetails(getStudent());
                    break;
                case 5:
                    // Show All Students
                    showAllStudents();
                    break;
                case 6:
                    // Back
                    return;
                break;
            }
        }
    }

    private void addStudent() {
        stdOut.println("Add Student");
        stdOut.println("-----------------");
        try {
            stdOut.print("\n>Enter Student Name: ");
            stdOut.flush();

            String name = stdIn.readLine();
            stdOut.print("\n>Enter Student Major: ");
            stdOut.flush();

            String major = stdIn.readLine();

            studentDatabase.addStudent(name, major);
        } catch (IOException e) {
            stdErr.println("Error Happened");
        }

    }

    private Student getStudent() {
        stdOut.println("Get Student");
        stdOut.println("-----------------");
        stdOut.print("\n>Enter Student ID: ");
        stdOut.flush();

        try {
            int id = Integer.parseInt(stdIn.readLine());
            return studentDatabase.getStudentById(id);
        } catch (IOException e) {
            stdErr.println("Error Happened");
        }
        return null;
    }

    private void depositLesson(Student student) {
        stdOut.println("Deposit Lesson for Student");
        stdOut.println("-----------------");
        try {
            stdOut.print("\n>Enter Lesson ID: ");
            stdOut.flush();

            int id = Integer.parseInt(stdIn.readLine());
            Lesson lesson = lessonDatabase.getLessonById(id);

            student.depositLesson(lesson);
        } catch (IOException e) {
            stdErr.println("Error Happened");
        }
    }

    private void withdrawLesson(Student student) {
        stdOut.println("Withdraw Lesson for Student");
        stdOut.println("-----------------");
        try {
            stdOut.print("\n>Enter Lesson ID: ");
            stdOut.flush();

            int id = Integer.parseInt(stdIn.readLine());
            Lesson lesson = lessonDatabase.getLessonById(id);

            student.withdrawLesson(lesson);
        } catch (IOException e) {
            stdErr.println("Error Happened");
        }
    }

    private void showStudentDetails(Student student) {
        stdOut.println(student.getId() + " " + student.getName() + " " + student.getMajor());
    }

    private void showAllStudents() {
        stdOut.println("All Students");
        stdOut.println("-----------------");
        for (Student student : studentDatabase.getStudents()) {
            stdOut.println(student.getId() + " " + student.getName() + " " + student.getMajor());
        }
    }

    private void LessonManagement() {
        stdOut.println("Lesson Management");
        while (true) {
            stdOut.println();
            stdOut.println("There is " + lessonDatabase.getSize() + " lesson(s) in the database.");
            stdOut.println("-----------------");
            stdOut.print("[1] Add Lesson\n" +
                    "[2] View Lesson Details\n" +
                    "[3] Show All Lessons\n" +
                    "[4] Back");
            stdOut.flush();

            int option = getChoice(1, 4);

            switch (option) {
                case 1:
                    // Add Lesson
                    addLesson();
                    break;
                case 2:
                    // View Lesson Details
                    showLessonDetails(getLesson());
                    break;
                case 3:
                    // Show All Lessons
                    showAllLessons();
                    break;
                case 4:
                    // Back
                    return;
                break;
            }
        }
    }

    private void addLesson() {
        stdOut.println("Add Lesson");
        stdOut.println("-----------------");
        try {
            stdOut.print("\n>Enter Lesson Name: ");
            stdOut.flush();

            String name = stdIn.readLine();
            stdOut.print("\n>Enter Lesson type: ");
            stdOut.flush();

            String type = stdIn.readLine();

            stdOut.print("\n>Enter Test Time (YYYY-MM-DD): ");
            stdOut.flush();

            String testTime = stdIn.readLine();

            stdOut.print("\n>Enter Test total score: ");
            stdOut.flush();

            int testTotalScore = Integer.parseInt(stdIn.readLine());

            lessonDatabase.addLesson(name, type, new Test(testTime, testTotalScore));
        } catch (IOException e) {
            stdErr.println("Error Happened");
        }
    }

    private Lesson getLesson() {
        stdOut.println("Get Lesson");
        stdOut.println("-----------------");
        stdOut.print("\n>Enter Lesson ID: ");
        stdOut.flush();

        try {
            int id = Integer.parseInt(stdIn.readLine());
            return lessonDatabase.getLessonById(id);
        } catch (IOException e) {
            stdErr.println("Error Happened");
        }
        return null;
    }

    private void showLessonDetails(Lesson lesson) {
        stdOut.println(lesson.getId() + " " + lesson.getName() + " " + lesson.getType());
    }

    private void showAllLessons() {
        stdOut.println("Show All Lessons");
        stdOut.println("-----------------");
        for (Lesson lesson : lessonDatabase.getLessons()) {
            stdOut.println(lesson.getId() + " " + lesson.getName() + " " + lesson.getType());
        }
        stdOut.println();
    }

    private void TeacherManagement() {
        stdOut.println("Teacher Management");
        while (true) {
            stdOut.println();
            stdOut.println("There is " + teacherDatabase.getSize() + " teacher(s) in the database.");
            stdOut.println("-----------------");
            stdOut.print("[1] Add Teacher\n" +
                    "[2] View Teacher Details\n" +
                    "[3] Show All Teachers\n" +
                    "[4] Back");
            stdOut.flush();

            int option = getChoice(1, 5);

            switch (option) {
                case 1:
                    // Add Teacher
                    addTeacher();
                    break;
                case 2:
                    // View Teacher Details
                    showTeacherDetails(getTeacher());
                    break;
                case 3:
                    // Show All Teachers
                    showAllTeachers();
                    break;
                case 4:
                    // Back
                    return;
                break;
            }
        }
    }

    private void addTeacher() {
        stdOut.println("Add Teacher");
        stdOut.println("-----------------");
        try {
            stdOut.print("\n>Enter Teacher Name: ");
            stdOut.flush();

            String name = stdIn.readLine();
            stdOut.print("\n>Enter Teacher Phone Number: ");
            stdOut.flush();

            String phoneNumber = stdIn.readLine();

            teacherDatabase.addTeacher(name, phoneNumber);
        } catch (IOException e) {
            stdErr.println("Error Happened");
        }
    }

    private Teacher getTeacher() {
        stdOut.println("Get Teacher");
        stdOut.println("-----------------");
        stdOut.print("\n>Enter Teacher ID: ");
        stdOut.flush();

        try {
            int id = Integer.parseInt(stdIn.readLine());
            return teacherDatabase.getTeacherById(id);
        } catch (IOException e) {
            stdErr.println("Error Happened");
        }
        return null;
    }

    private void showTeacherDetails(Teacher teacher) {
        stdOut.println(teacher.getId() + " " + teacher.getName() + " " + teacher.getPhoneNumber());
    }

    private void showAllTeachers() {
        stdOut.println("Show All Teachers");
        stdOut.println("-----------------");
        for (Teacher teacher : teacherDatabase.getTeachers()) {
            stdOut.println(teacher.getId() + " " + teacher.getName() + " " + teacher.getPhoneNumber());
        }
        stdOut.println();
    }

}
