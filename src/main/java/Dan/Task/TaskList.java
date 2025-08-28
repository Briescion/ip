package Dan.Task;

import Dan.Storage.Storage;
import java.util.ArrayList;

public class TaskList {
    Storage store;
    ArrayList<Task> taskList = new ArrayList<>();

    public TaskList(Storage store) {
        this.store = store;
        this.taskList = store.getTaskList();
    }

    public void add(Task task) {
        taskList.add(task);
        store.writeData(taskList);
    }

    public void delete(int index) {
        taskList.remove(index - 1);
        store.writeData(taskList);
    }

    public void markDone(int index) {
        try {
            Task task = taskList.get(index - 1);
            task.markDone();
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Type in a valid index");
        }
    }

//    public void list() {
//        for(int i = 1; i < taskList.size() + 1; i++) {
//            System.out.println(i + "." + taskList.get(i - 1));
//        }
//    }

    public Task getTask(int index) {
        return taskList.get(index - 1);
    }

    public int size() {
        return taskList.size();
    }
}
