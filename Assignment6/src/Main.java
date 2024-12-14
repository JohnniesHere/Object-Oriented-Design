public class Main {
    public static void main(String[] args) {
        // Create workers
        TeamMember worker1 = new TeamMember("Worker 1", "ID001", 10000);
        TeamMember worker2 = new TeamMember("Worker 2", "ID002", 30000);

        // Create tasks for Worker 1
        Task task1Worker1 = new Task("Task 1", 5, 5);  // On time
        Task task2Worker1 = new Task("Task 2", 5, 3);  // Early

        // Create tasks for Worker 2
        Task task1Worker2 = new Task("Task 1", 5, 5);  // On time
        Task task2Worker2 = new Task("Task 2", 5, 7);  // Late
        Task task3Worker2 = new Task("Task 3", 5, 8);  // Late

        // Add tasks to workers
        worker1.addTask(task1Worker1);
        worker1.addTask(task2Worker1);

        worker2.addTask(task1Worker2);
        worker2.addTask(task2Worker2);
        worker2.addTask(task3Worker2);

        // Calculate and display bonuses
        System.out.println("Worker 1 Bonus: " + worker1.calculateBonus());  // Should be 15000
        System.out.println("Worker 2 Bonus: " + worker2.calculateBonus());  // Should be 10000
    }
}