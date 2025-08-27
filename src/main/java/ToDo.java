public class ToDo extends Task {
    public ToDo(String description) {
       super(description);
    }

    public TaskType getTaskType() {
        return TaskType.TODO;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
