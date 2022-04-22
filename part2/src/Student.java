import java.util.ArrayList;

/**
 * 
 * @author Huang Xuda Samuel
 *
 */
public class Student{

	private int id;
	private String name;
	private String major;
	private ArrayList<Lesson> lessons;
	
	public Student(int id, String name,String major) {
		this.id = id;
		this.name = name;
		this.major = major;
		lessons = new ArrayList<Lesson>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
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