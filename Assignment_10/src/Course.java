import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Course {
    private final String courseName;
    private final String instructor;
    private final int credits;
    private final Set<Student> students;

    public Course(String courseName, String instructor, int credits) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
        this.students = new HashSet<>();
    }

    public String getCourseName() { return courseName; }
    public String getInstructor() { return instructor; }
    public int getCredits() { return credits; }
    public Set<Student> getStudents() { return Collections.unmodifiableSet(students); }
    void addStudent(Student student) { students.add(student); }
    void removeStudent(Student student) { students.remove(student); }
}