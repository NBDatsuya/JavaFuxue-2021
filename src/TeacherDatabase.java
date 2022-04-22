import java.util.*;
public class TeacherDatabase
implements DatabaseCountable {
	private ArrayList<Teacher> teachers;
	private static TeacherDatabase instance=null;
	private TeacherDatabase() {};
	public static TeacherDatabase getInstance() {
		if(instance==null) {
			instance=new TeacherDatabase();
		}
		return instance;
	}
	public Teacher getTeacherById(int id) {
		Iterator<Teacher> ddq=teachers.iterator();
		while(ddq.hasNext()) {
			Teacher t=ddq.next();
			if(t.getId()==id) {
				return t;
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
	public void addTeacher(String name,String phoneNumber) {
		int id=this.getSize()+1;
		Teacher t=new Teacher(id,name,phoneNumber);
		teachers.add(t);
	}
	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}
}
