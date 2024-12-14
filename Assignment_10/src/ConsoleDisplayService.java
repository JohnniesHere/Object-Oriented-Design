import java.util.List;

class ConsoleDisplayService implements DisplayService {
    @Override
    public void displayCourse(Course course) {
        System.out.println(String.format("Course: %s, Instructor: %s, Credits: %d, Students: %d",
                course.getCourseName(),
                course.getInstructor(),
                course.getCredits(),
                course.getStudents().size()));
    }

    @Override
    public void displayStudent(Student student) {
        System.out.println(String.format("Student: %s (ID: %d), Enrolled in %d courses",
                student.getName(),
                student.getId(),
                student.getCourses().size()));
    }

    @Override
    public void displayCourseList(List<Course> courses) {
        System.out.println("\nCourses:");
        courses.forEach(this::displayCourse);
    }

    @Override
    public void displayStudentList(List<Student> students) {
        System.out.println("\nStudents:");
        students.forEach(this::displayStudent);
    }
}