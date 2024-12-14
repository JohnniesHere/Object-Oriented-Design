import java.util.List;

public class TeamMember extends Worker{
    public TeamMember(String name, String id, double salary) {
        super(name, id, salary);
    }

    @Override
    public double calculateBonus() {
        if (tasks.isEmpty()){
            return 0;
        }

        double factor = salary/tasks.size();
        double totalBonus = 0;

        for (Task task : tasks) {
            if (task.getActualDays() == task.getEstimatedDays()){
                totalBonus += factor;
            } else if (task.getActualDays() < task.getEstimatedDays()) {
                totalBonus += 2 * factor;
            }
        }

        this.bonus = totalBonus;
        return bonus;
    }
}
