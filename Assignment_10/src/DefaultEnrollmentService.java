import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DefaultEnrollmentService implements EnrollmentService {
    private final CourseRepo courseRepository;
    private final StudentRepo studentRepository;

    public DefaultEnrollmentService(CourseRepo courseRepository,
                                    StudentRepo studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void enrollStudent(String studentName, String courseName) {
        Course course = courseRepository.findByName(courseName);
        if (course == null) {
            throw new IllegalArgumentException("Course not found: " + courseName);
        }

        Student student = studentRepository.findByName(studentName);
        if (student == null) {
            student = new Student(studentName);
            studentRepository.addStudent(student);
        }

        course.addStudent(student);
        student.addCourse(course);
    }

    @Override
    public void unenrollStudent(String studentName, String courseName) {
        Course course = courseRepository.findByName(courseName);
        Student student = studentRepository.findByName(studentName);

        if (course != null && student != null) {
            course.removeStudent(student);
            student.removeCourse(course);
        }
    }

    @Override
    public List<Student> getEnrolledStudents(String courseName) {
        Course course = courseRepository.findByName(courseName);
        return course != null ?
                new ArrayList<>(course.getStudents()) :
                Collections.emptyList();
    }

    @Override
    public List<Course> getStudentCourses(String studentName) {
        Student student = studentRepository.findByName(studentName);
        return student != null ?
                new ArrayList<>(student.getCourses()) :
                Collections.emptyList();
    }
}