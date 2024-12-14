class Main {
    public static void main(String[] args) {

        // Create repositories and services
        CourseRepo courseRepo = new InMemoryCourseRepo();
        StudentRepo studentRepo = new InMemoryStudentRepo();
        EnrollmentService enrollmentService = new DefaultEnrollmentService(courseRepo, studentRepo);
        DisplayService displayService = new ConsoleDisplayService();

        // Create academy management instance
        AcademyManagement academy = new AcademyManagement(
                courseRepo, studentRepo, enrollmentService, displayService);

        System.out.println("=== Academy Management System Demonstration ===\n");

        // 1. Demonstrate adding courses
        System.out.println("1. Adding Courses:");
        academy.addCourse("Java Programming", "John Doe", 4);
        academy.addCourse("Database Systems", "Jane Smith", 3);
        academy.addCourse("Web Development", "Bob Wilson", 5);
        academy.addCourse("Python Programming", "Alice Brown", 4);
        System.out.println();

        // 2. Show all courses
        System.out.println("2. Showing All Courses:");
        academy.showAllCourses();
        System.out.println();

        // 3. Add students to courses
        System.out.println("3. Adding Students to Courses:");
        academy.addStudentToCourse("Alice Johnson", "Java Programming");
        academy.addStudentToCourse("Bob Brown", "Java Programming");
        academy.addStudentToCourse("Charlie Davis", "Database Systems");
        academy.addStudentToCourse("Alice Johnson", "Database Systems");
        System.out.println();

        // 4. Show students in a specific course
        System.out.println("4. Showing Students in Java Programming:");
        academy.showStudentsInCourse("Java Programming");
        System.out.println();

        // 5. Sort courses by credits
        System.out.println("5. Sorting Courses by Credits (Ascending):");
        academy.sortCoursesByCredits(true);
        System.out.println();

        // 6. Search for a course
        System.out.println("6. Searching for a Course:");
        academy.searchCourse("Java Programming");
        academy.searchCourse("Artificial Intelligence"); // Non-existent course
        System.out.println();

        // 7. Search for a student
        System.out.println("7. Searching for a Student:");
        academy.searchStudent("Alice Johnson");
        academy.searchStudent("David Wilson"); // Non-existent student
        System.out.println();

        // 8. Remove a student from a course
        System.out.println("8. Removing Student from Course:");
        academy.removeStudentFromCourse("Bob Brown", "Java Programming");
        System.out.println("\nUpdated student list for Java Programming:");
        academy.showStudentsInCourse("Java Programming");
        System.out.println();

        // 9. Sort courses by credits (descending)
        System.out.println("9. Sorting Courses by Credits (Descending):");
        academy.sortCoursesByCredits(false);
    }
}