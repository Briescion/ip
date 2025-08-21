public class Deadline extends Task {
    private String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
        this.deadline = "(by:" + deadline + ")";
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() +  deadline;
    }
}
