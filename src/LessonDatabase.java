import java.util.*;
public class LessonDatabase 
implements DatabaseCountable {
	private ArrayList<Lesson> lessons;
	private static LessonDatabase instance=null;
	private LessonDatabase() {};
	public static LessonDatabase getInstance() {
		if(instance==null) {
			instance=new LessonDatabase();
		}
		return instance;
	}
	@Override
	public int getSize() {
		return lessons.size();
	}
	public Lesson getStudentById(int id) {
		Iterator<Lesson> ddq=lessons.iterator();
		while(ddq.hasNext()) {
			Lesson l=ddq.next();
			if(l.getId()==id) {
				return l;
			}
		}
		return null;
	}
	public ArrayList<Lesson> getStudents(){
		return lessons;
	}
	public void addLesson(String name,String type,Test test) {
		int id=this.getSize()+1;
		Lesson l=new Lesson(id,name,type);
		lessons.add(l);
	}
	public void addLesson(Lesson lesson) {
		lessons.add(lesson);
	}

}
