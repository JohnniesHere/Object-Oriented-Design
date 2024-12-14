import java.util.List;

interface CourseRepo {
    void addCourse(Course course);
    Course findByName(String courseName);
    List<Course> getAllCourses();
    void sortByCredits(boolean ascending);
}