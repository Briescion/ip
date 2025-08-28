package Dan.Parser;

import Dan.Command.*;
import Dan.Task.Task;

import Dan.Task.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.IllegalArgumentException;

public class Parser {

    private static final String MARK_REGEX =  "^mark (-?\\d+)$";
    private static final String DELETE_REGEX =  "^delete (-?\\d+)$";
    private static final String TODO_REGEX = "^todo (.+)$";
    private static final String DEADLINE_REGEX = "^deadline (.+) /by (.+)$";
    private static final String EVENT_REGEX = "^event (.+) /from (.+) /to (.+)$";

    private static Task parseDataStringToTask(String dataString) throws IllegalArgumentException  {
        String[] dataStringComponents = dataString.split("\\|");
        String[] taskInfo = Arrays.stream(dataStringComponents).map(String::trim).toArray(String[]::new);
        return Task.createTask(taskInfo);
    }

    public static ArrayList<Task> parseDataStringListToTasks(List<String> stringDataList) {
        ArrayList<Task> tasks = new ArrayList<>();

        for(int i = 0; i < stringDataList.size(); i++) {
            String dataString = stringDataList.get(i);
            Task task = parseDataStringToTask(dataString);
            tasks.add(task);
        }

        return tasks;
    }

    public static String parseTaskToDataString(Task task) {
        String data = "";

        switch (task.getTaskType()) {
            case TODO:
                ToDo todo = (ToDo) task;
                data += "T | ";
                data += todo.isDone().toString() + " | ";
                data += todo.getDescription().trim();
                break;
            case DEADLINE:
                Deadline deadline = (Deadline) task;
                data += "D | ";
                data += deadline.isDone().toString() + " | ";
                data += deadline.getDescription().trim() + " | ";
                data += deadline.getDeadlineDate();
                break;
            case EVENT:
                Event event = (Event) task;
                data += "E | ";
                data += event.isDone().toString() + " | ";
                data += event.getDescription().trim() + " | ";
                data += event.getFromDate() + " | ";
                data += event.getToDate();
                break;
        }

        return data;
    }

    public static String parseTasksToDataString(ArrayList<Task> tasks) {
        String dataString = "";

        for (int i = 0; i < tasks.size(); i++) {
            String taskDataString = parseTaskToDataString(tasks.get(i));
            dataString = dataString + taskDataString + System.lineSeparator();
        }

        return dataString;
    }

    public static Command parseUserInput(String str) throws IllegalArgumentException {
        if (str.equals("list")) {
            return new ListCommand();
        } else if (str.matches(MARK_REGEX)){
            String[] temp = str.split(" ");
            int index = Integer.parseInt(temp[1]);
            return new MarkCommand(index);
        } else if (str.matches(DELETE_REGEX)) {
            String indexStr = str.replaceFirst("delete ", "");
            int index = Integer.parseInt(indexStr);
            return new DeleteCommand(index);
        } else if (str.matches(TODO_REGEX)){
            String desc = str.replaceFirst("todo", "");
            String[] taskInfo = {"T", "false", desc};
            Task toDO = Task.createTask(taskInfo);
            return new ToDoCommand(toDO);
        } else if (str.matches(EVENT_REGEX)) {
            String withoutEvent = str.replaceFirst("event", "");
            String[] fromSplit = withoutEvent.split("/from", 2);

            if (fromSplit.length != 2) {
               throw new IllegalArgumentException();
            }

            String desc = fromSplit[0];
            String duration = fromSplit[1];
            String[] times = duration.split("/to", 2);

            if (times.length != 2) {
                throw new IllegalArgumentException();
            }

            String from = times[0];
            String to = times[1];

            String[] taskInfo = {"E", "false", desc, from, to};
            Task event = Task.createTask(taskInfo);
            return new EventCommand(event);
        } else if (str.matches(DEADLINE_REGEX)){
            String withoutDeadline = str.replaceFirst("deadline", "");
            String[] bySplit = withoutDeadline.split("/by", 2);

            if (bySplit.length != 2) {
               throw new IllegalArgumentException();
            }

            String desc = bySplit[0];
            String by = bySplit[1];

            String[] taskInfo = {"D", "false", desc, by};
            Task deadline = Task.createTask(taskInfo);
            return new DeadlineCommand(deadline);
        } else if (str.equals("bye")) {
            return new ExitCommand();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
