import java.util.ArrayList;

public class TaskList {
    Storage store = new Storage();
    ArrayList<Task> taskList = new ArrayList<>();

    public TaskList() {
//        store.getData()
//        taskList
    }

    public void add(Task task) {
        taskList.add(task);
        store.writeData(taskList);
    }

    public void remove(int index) {
        taskList.remove(index);
        store.writeData(taskList);
    }
}
