package Command;

import Task.TaskList;
import Task.Task;

public class ToDoCommand extends Command {
    Task toDo;

    public ToDoCommand(Task t) {
        this.toDo = t;
    }

    public CommandType getType() {
        return CommandType.TODO;
    }

    public void execute(TaskList taskList) {
        taskList.add(toDo);
        System.out.println("Got it. I've added this task: \n " + toDo + "\nNow you have " + taskList.size() + " tasks in the list.");
    }
}
