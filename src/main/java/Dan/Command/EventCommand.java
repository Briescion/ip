package Dan.Command;

import Dan.Task.TaskList;
import Dan.Task.Task;

public class EventCommand extends Command {
    Task event;

    public EventCommand(Task e) {
        this.event = e;
    }

    public CommandType getType() {
        return  CommandType.EVENT;
    }

    public String execute(TaskList taskList) {
        taskList.add(event);
        return "Got it. I've added this task: \n " + event + "\nNow you have " + taskList.size() + " tasks in the list.";
    }
}
