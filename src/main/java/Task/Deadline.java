package Task;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Deadline extends Task {
    private LocalDateTime deadlineDate;

    public Deadline(String isDone, String description, LocalDateTime  deadlineDate) {
        super(isDone, description);
        this.deadlineDate = deadlineDate;
    }

    public static Task create(ArrayList<String> taskInfo) throws IllegalArgumentException {
        if (taskInfo.size() != 3) {
           throw new IllegalArgumentException();
        }

        String isDone = taskInfo.get(0);
        String description = taskInfo.get(1);

        String deadlineString = taskInfo.get(2);
        LocalDateTime deadline = LocalDateTime.parse(deadlineString);

        return new Deadline(isDone, description, deadline);
    }

    public LocalDateTime getDeadlineDate() {
        return this.deadlineDate;
    }

    public TaskType getTaskType() {
        return TaskType.DEADLINE;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by:" + this.deadlineDate + ")";
    }
}
