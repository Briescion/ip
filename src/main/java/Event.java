public class Event extends Task {
    private String duration;

    public Event(String description, String from, String to) {
        super(description);
        this.duration= "(from:" + from + " to:" + to + ")";
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + duration;
    }
}


