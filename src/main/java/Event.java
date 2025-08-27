import java.time.Duration;

public class Event extends Task {
    private String duration;

    public Event(String description, String from, String to) {
        super(description);
        this.duration = "(from:" + from + " to:" + to + ")";
    }

    public String getDuration() {
        return this.duration;
    }

    public TaskType getTaskType() {
        return TaskType.EVENT;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + duration;
    }
}


