import java.util.List;

interface DisplayService {
    void displayCourse(Course course);
    void displayStudent(Student student);
    void displayCourseList(List<Course> courses);
    void displayStudentList(List<Student> students);
}