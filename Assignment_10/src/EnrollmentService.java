import java.util.List;

interface EnrollmentService {
    void enrollStudent(String studentName, String courseName);
    void unenrollStudent(String studentName, String courseName);
    List<Student> getEnrolledStudents(String courseName);
    List<Course> getStudentCourses(String studentName);
}