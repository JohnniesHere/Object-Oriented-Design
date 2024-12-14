import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Student {
    private final String name;
    private final int id;
    private final Set<Course> courses;
    private static int nextId = 1000;

    public Student(String name) {
        this.name = name;
        this.id = nextId++;
        this.courses = new HashSet<>();
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public Set<Course> getCourses() { return Collections.unmodifiableSet(courses); }
    void addCourse(Course course) { courses.add(course); }
    void removeCourse(Course course) { courses.remove(course); }
}