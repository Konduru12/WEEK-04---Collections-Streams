import java.util.ArrayList;
import java.util.List;
abstract class TypeOfCourse{
    final private String course;
    public TypeOfCourse(String course) {
        this.course = course;
    }
    public String getCourse() {
        return course;
    }
    public abstract String getcoursetype();
    @Override
    public String toString() {
        return getcoursetype() + " | Evaluation: " + getCourse();
    }
}
class Exambased extends TypeOfCourse{
    public Exambased() {
        super("Exam-Based");
    }
    @Override
    public String getcoursetype() {
        return "Exam course";
    }
}
class AssignmentBased extends TypeOfCourse {
    public AssignmentBased() {
        super("Assignment-Based");
    }
    @Override
    public String getcoursetype() {
        return "Assignment-Course";
    }
}
class ResearchBased extends TypeOfCourse{
    public ResearchBased() {
        super("Research-Based");
    }
    @Override
    public String getcoursetype() {
        return "Research-course";
    }
}
class Course<T extends TypeOfCourse> {
    final private String coursename;
    final private T type;
    public Course(String coursename, T type) {
        this.coursename = coursename;
        this.type = type;
    }
    public String getcoursename() {
        return coursename;
    }
    public T gettype() {
        return type;
    }
    public void display() {
        System.out.println(coursename + " , " + type.getcoursetype());
    }
    public static void displayall(List<? extends TypeOfCourse> types) {
        for (TypeOfCourse cs : types) {
            System.out.println(cs);
        }
    }
}
public class UniversityCourseManagement {
    public static void main(String[] args) {
        Course<Exambased> math = new Course<>("Computer science", new Exambased());
        Course<AssignmentBased> english = new Course<>("Cyber crime", new AssignmentBased());
        Course<ResearchBased> ai = new Course<>("AIML research", new ResearchBased());
        math.display();
        english.display();
        ai.display();
        List<TypeOfCourse> allCourses = new ArrayList<>();
        allCourses.add(new Exambased());
        allCourses.add(new AssignmentBased());
        allCourses.add(new ResearchBased());
        System.out.println("\nDisplaying all course types:");
        Course.displayall(allCourses); 
    }
}
