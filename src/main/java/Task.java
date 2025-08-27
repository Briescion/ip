public abstract class Task {
    private String description;
    private Boolean isDone = false;

    public Task(String description) {
        this.description = description;
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
