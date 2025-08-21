public class TaskList {
    Task[] taskList = new Task[100];
    int endIndex = 0;

    public void addTask(Task task) {
        taskList[endIndex] = task;
        endIndex++;
    }

    public int length() {
        return endIndex;
    }

    public String getTaskName(int i) {
        return taskList[i].name;
    }

    public Task get(int i) {
        return taskList[i];
    }
}
