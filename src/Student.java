import java.util.ArrayList;

/**
 * 
 * @author Huang Xuda Samuel
 *
 */
public class Student extends Person{
	private String major;
	private ArrayList<Lesson> lessons;
	
	public Student(int id, String name,String major) {
		super(id, name);
		this.major = major;
		lessons = new ArrayList<Lesson>();
	}
	
	public String getMajor() {
		return major;
	}
    public ArrayList<Lesson> getLessons(){
    	return lessons;
    }
    public void addLesson(Lesson lesson) {
    	lessons.add(lesson);
    }
    public void withdrawLesson(Lesson lesson) {
    	lessons.remove(lesson);
    }
    public void withdrawLesson(int index) {
    	lessons.remove(index);
    }
    
}