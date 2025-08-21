public class Task {
    private String name;
    private Boolean isDone = false;
    public Task(String name) {
        this.name = name;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public Boolean isDone() {
        return this.isDone;
    }

    public void markDone() {
        this.isDone = true;
    }

//    public void markUndone() {
//       this.isDone = false;
//    }

    @Override
    public String toString() {
        return this.name;
    }
}
