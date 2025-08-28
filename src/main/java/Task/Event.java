package Task;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event extends Task {
    LocalDateTime fromDate;
    LocalDateTime toDate;

    public Event(String isDone, String description, LocalDateTime from, LocalDateTime to) {
        super(isDone, description);
        this.fromDate = from;
        this.toDate = to;
    }

    public static Task create(ArrayList<String> taskInfo) throws IllegalArgumentException {
        if (taskInfo.size() != 4) {
            throw new IllegalArgumentException();
        }

        String isDone = taskInfo.get(0);
        String description = taskInfo.get(1);
        LocalDateTime fromDate = LocalDateTime.parse(taskInfo.get(2));
        LocalDateTime toDate = LocalDateTime.parse(taskInfo.get(3));

        return new Event(isDone, description, fromDate, toDate);
    }

    public LocalDateTime getFromDate() {
        return this.fromDate;
    }

    public LocalDateTime getToDate() {
        return this.toDate;
    }

    public TaskType getTaskType() {
        return TaskType.EVENT;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from:" + this.fromDate + " to:" + this.toDate + ")";
    }
}


