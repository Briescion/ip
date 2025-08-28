package Dan.Task;

import Dan.Storage.Storage;
import java.util.ArrayList;

public class TaskList {
    Storage store;
    ArrayList<Task> taskList = new ArrayList<>();

    /**
     * Constructs a new TaskList with the specified storage.
     * Initializes the task list by retrieving existing tasks from storage.
     *
     * @param store the Storage object used for data persistence
     */
    public TaskList(Storage store) {
        this.store = store;
        this.taskList = store.getTaskList();
    }

    /**
     * Adds a task to the task list and saves the updated list to storage.
     *
     * @param task the Task object to be added to the list
     */
    public void add(Task task) {
        taskList.add(task);
        store.writeData(taskList);
    }

    /**
     * Deletes a task at the specified index from the task list and saves the updated list to storage.
     * Uses 1-based indexing (index 1 corresponds to the first task).
     *
     * @param index the 1-based index of the task to be deleted
     */
    public void delete(int index) {
        taskList.remove(index - 1);
        store.writeData(taskList);
    }

    /**
     * Marks a task as done at the specified index.
     * Uses 1-based indexing (index 1 corresponds to the first task).
     * Prints an error message if the index is invalid.
     *
     * @param index the 1-based index of the task to be marked as done
     */
    public void markDone(int index) {
        try {
            Task task = taskList.get(index - 1);
            task.markDone();
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Type in a valid index");
        }
    }

    /**
     * Retrieves a task at the specified index from the task list.
     * Uses 1-based indexing (index 1 corresponds to the first task).
     *
     * @param index the 1-based index of the task to retrieve
     * @return the Task object at the specified index
     */
    public Task getTask(int index) {
        return taskList.get(index - 1);
    }

    /**
     * Returns the number of tasks in the task list.
     *
     * @return the size of the task list
     */
    public int size() {
        return taskList.size();
    }
}
