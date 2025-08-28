package Dan.Task;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Task {
    private String description;
    private Boolean isDone = false;

    public Task(String isDone, String description) {
        this.description = description;
        this.isDone = Boolean.valueOf(isDone);
    }

    public static Task createTask(String[] taskInfo) throws IllegalArgumentException {
        if (taskInfo.length < 1) {
            throw new IllegalArgumentException();
        }

        ArrayList<String> taskInfoArr = new ArrayList<String>(Arrays.asList(taskInfo));
        String taskType = taskInfoArr.get(0);
        taskInfoArr.remove(0);

        switch (taskType) {
            case "T":
                return ToDo.create(taskInfoArr);
            case "D":
                return Deadline.create(taskInfoArr);
            case "E":
                return Event.create(taskInfoArr);
            default:
                throw new IllegalArgumentException();
        }
    }

    public String getStatusIcon() {
        return (isDone ? "[X] " : "[ ]"); // mark done task with X
    }

    public Boolean isDone() {
        return this.isDone;
    }

    public void markDone() {
        this.isDone = true;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract TaskType getTaskType();

//    public void markUndone() {
//       this.isDone = false;
//    }

    @Override
    public String toString() {
        return this.getStatusIcon() + this.description;
    }
}
