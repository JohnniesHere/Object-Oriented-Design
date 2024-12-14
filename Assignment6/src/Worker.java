import java.util.ArrayList;
import java.util.List;

public class Worker {
    protected String name;
    protected String id;
    protected List<Task> tasks;
    protected double salary;
    protected double bonus;

    public Worker(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.bonus = 0;
        this.tasks = new ArrayList<>();
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public double calculateBonus() {
        return 0;
    }
}
