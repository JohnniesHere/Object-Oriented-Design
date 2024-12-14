import java.util.List;

class AcademyManagement {
    private final CourseRepo courseRepository;
    private final StudentRepo studentRepository;
    private final EnrollmentService enrollmentService;
    private final DisplayService displayService;

    public AcademyManagement(
            CourseRepo courseRepository,
            StudentRepo studentRepository,
            EnrollmentService enrollmentService,
            DisplayService displayService
    ) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.enrollmentService = enrollmentService;
        this.displayService = displayService;
    }

    // Requirement 1: Add a course
    public void addCourse(String courseName, String instructor, int credits) {
        Course newCourse = new Course(courseName, instructor, credits);
        courseRepository.addCourse(newCourse);
        System.out.println("Course added successfully: " + courseName);
    }

    // Requirement 2: Add a student to a course
    public void addStudentToCourse(String studentName, String courseName) {
        try {
            enrollmentService.enrollStudent(studentName, courseName);
            System.out.println("Student " + studentName + " successfully enrolled in " + courseName);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Requirement 3: Show all courses
    public void showAllCourses() {
        List<Course> allCourses = courseRepository.getAllCourses();
        if (allCourses.isEmpty()) {
            System.out.println("No courses available in the academy.");
        } else {
            displayService.displayCourseList(allCourses);
        }
    }

    // Requirement 4: Show students in a course
    public void showStudentsInCourse(String courseName) {
        List<Student> students = enrollmentService.getEnrolledStudents(courseName);
        if (students.isEmpty()) {
            System.out.println("No students enrolled in course: " + courseName);
        } else {
            System.out.println("\nStudents enrolled in " + courseName + ":");
            displayService.displayStudentList(students);
        }
    }

    // Requirement 5: Sort courses by credits
    public void sortCoursesByCredits(boolean ascending) {
        courseRepository.sortByCredits(ascending);
        System.out.println("\nCourses sorted by credits (" +
                (ascending ? "ascending" : "descending") + "):");
        showAllCourses();
    }

    // Requirement 6: Remove student from course
    public void removeStudentFromCourse(String studentName, String courseName) {
        enrollmentService.unenrollStudent(studentName, courseName);
        System.out.println("Student " + studentName + " removed from course " + courseName);
    }

    // Requirement 7: Search for a course
    public void searchCourse(String courseName) {
        Course course = courseRepository.findByName(courseName);
        if (course != null) {
            System.out.println("\nCourse found:");
            displayService.displayCourse(course);
        } else {
            System.out.println("Course not found: " + courseName);
        }
    }

    // Requirement 8: Search for a student
    public void searchStudent(String studentName) {
        Student student = studentRepository.findByName(studentName);
        if (student != null) {
            System.out.println("\nStudent found:");
            displayService.displayStudent(student);
            List<Course> courses = enrollmentService.getStudentCourses(studentName);
            System.out.println("Enrolled in the following courses:");
            displayService.displayCourseList(courses);
        } else {
            System.out.println("Student not found: " + studentName);
        }
    }
}