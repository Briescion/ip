package Dan.Command;

import Dan.Task.TaskList;
import Dan.Task.Task;
import Dan.Task.TaskType;

public class ToDoCommand extends Command {
    Task toDo;

    public ToDoCommand(Task t) {
        this.toDo = t;
    }

    public CommandType getType() {
        return CommandType.TODO;
    }

    public String execute(TaskList tasks) {
        assert toDo.getTaskType() == TaskType.TODO;
        tasks.add(toDo);
        return "Got it. I've added this task: \n " + toDo + "\nNow you have " + tasks.size() + " tasks in the list.";
    }
}
