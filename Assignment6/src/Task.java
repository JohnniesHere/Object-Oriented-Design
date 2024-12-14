public class Task{
    private String taskName;
    private int estimatedDays;
    private int actualDays;

    public Task(String taskName, int estimatedDays, int actualDays){
        this.taskName = taskName;
        this.estimatedDays = estimatedDays;
        this.actualDays = actualDays;
    }

    public String getTaskName(){
        return taskName;
    }

    public int getEstimatedDays(){
        return estimatedDays;
    }

    public int getActualDays(){
        return actualDays;
    }

    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public void setEstimatedDays(int estimatedDays){
        this.estimatedDays = estimatedDays;
    }

    public void setActualDays(int actualDays){
        this.actualDays = actualDays;
    }

    public String getWorkerPerformance(){
        if (actualDays == estimatedDays){
            return "On Time";
        } else if (actualDays < estimatedDays) {
            return "Early";
        } else {
            return "Late";
        }
    }
}