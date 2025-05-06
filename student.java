import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Student {
    private String name;
    private Date dateOfBirth;

    public Student(String name, String dob) throws ParseException {
        this.name = name;
        SimpleDateFormat format;
        if (dob.contains("-")) {
            format = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            format = new SimpleDateFormat("dd-MM-yyyy");
        }
        this.dateOfBirth = format.parse(dob);
    }

    public void displayDetails() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Student Name: " + name);
        System.out.println("Date of Birth: " + format.format(dateOfBirth));
        System.out.println("Age: " + calculateAge());
    }

    private int calculateAge() {
        Calendar dobCal = Calendar.getInstance();
        dobCal.setTime(dateOfBirth);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dobCal.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < dobCal.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    public static void main(String[] args) {
        try {
            Student student = new Student("Alice", "2000-05-10");
            student.displayDetails();
        } catch (ParseException e) {
            System.out.println("Invalid date format. Use 'DD-MM-YYYY' or 'YYYY-MM-DD'.");
        }
    }
}