import java.util.Collection;

interface StudentRepo {
    void addStudent(Student student);
    Student findByName(String studentName);
    Collection<Student> getAllStudents();
}