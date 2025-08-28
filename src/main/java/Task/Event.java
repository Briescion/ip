package Task;

import Parser.DateParser;

import java.time.LocalDate;
import java.util.ArrayList;

public class Event extends Task {
    LocalDate fromDate;
    LocalDate toDate;

    public Event(String isDone, String description, LocalDate from, LocalDate to) {
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

        LocalDate fromDate = DateParser.parseDate(taskInfo.get(2));
        LocalDate toDate = DateParser.parseDate(taskInfo.get(3));

        return new Event(isDone, description, fromDate, toDate);
    }

    public LocalDate getFromDate() {
        return this.fromDate;
    }

    public LocalDate getToDate() {
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


