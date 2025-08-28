package Dan.Task;

import Dan.Storage.Storage;
import java.util.ArrayList;
import java.util.Arrays;

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


    public void mark(int index) {
        try {
            Task task = taskList.get(index - 1);
            task.mark();
            store.writeData(taskList);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Type in a valid index");
        }
    }

    public Task getTask(int index) {
        return taskList.get(index - 1);
    }

    public ArrayList<Task> find(String searchStr) {
        return new ArrayList<>(this.taskList
                .stream()
                .filter(task -> task.getDescription().contains(searchStr))
                .toList());
    }

    public int size() {
        return taskList.size();
    }
}
