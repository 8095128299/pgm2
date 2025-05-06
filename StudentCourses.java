import java.util.HashMap;
import java.util.Map;

public class StudentCourses {
    private Map<String, Map<String, Integer>> semesterCourses;

    public StudentCourses() {
        this.semesterCourses = new HashMap<>();
    }

    public void addCourse(String semester, String courseName, int marks) {
        semesterCourses.putIfAbsent(semester, new HashMap<>());
        semesterCourses.get(semester).put(courseName, marks);
    }

    public void displayCourses() {
        System.out.println("Student Course Details:");
        for (String semester : semesterCourses.keySet()) {
            System.out.println("Semester: " + semester);
            for (Map.Entry<String, Integer> entry : semesterCourses.get(semester).entrySet()) {
                System.out.println("Course: " + entry.getKey() + " | Marks: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        StudentCourses courses = new StudentCourses();
        courses.addCourse("Semester 1", "Math", 85);
        courses.addCourse("Semester 1", "Physics", 90);
        courses.addCourse("Semester 2", "Computer Science", 95);
        courses.displayCourses();
    }
}