import java.util.*;
public class StudentDatabase 
implements DatabaseCountable {
	private ArrayList<Student> students;
	private static StudentDatabase instance=null;
	private StudentDatabase() {};
	public static StudentDatabase getInstance() {
		if(instance==null) {
			instance=new StudentDatabase();
		}
		return instance;
	}
	@Override
	public int getSize() {
		return students.size();
	}
	public Student getStudentById(int id) {
		Iterator<Student> ddq=students.iterator();
		while(ddq.hasNext()) {
			Student s=ddq.next();
			if(s.getId()==id) {
				return s;
			}
		}
		return null;
	}
	public ArrayList<Student> getStudents(){
		return students;
	}
	public void addStudent(String name,String major) {
		int id=this.getSize()+1;
		Student s=new Student(id,name,major);
		students.add(s);
	}
	public void addStudent(Student student) {
		students.add(student);
	}
}
