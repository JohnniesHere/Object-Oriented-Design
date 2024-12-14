import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class InMemoryStudentRepo implements StudentRepo {
    private final Map<String, Student> students = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        students.putIfAbsent(student.getName(), student);
    }

    @Override
    public Student findByName(String studentName) {
        return students.get(studentName);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
}