import java.util.ArrayList;
import java.util.List;

class InMemoryCourseRepo implements CourseRepo {
    private final List<Course> courses = new ArrayList<>();

    @Override
    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public Course findByName(String courseName) {
        return courses.stream()
                .filter(c -> c.getCourseName().equalsIgnoreCase(courseName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    @Override
    public void sortByCredits(boolean ascending) {
        courses.sort((c1, c2) -> ascending ?
                Integer.compare(c1.getCredits(), c2.getCredits()) :
                Integer.compare(c2.getCredits(), c1.getCredits()));
    }
}
