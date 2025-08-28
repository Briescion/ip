package Command;

import Task.TaskList;
import Task.Task;

public class EventCommand extends Command {
    Task event;

    public EventCommand(Task e) {
        this.event = e;
    }

    public CommandType getType() {
        return  CommandType.EVENT;
    }

    public void execute(TaskList taskList) {
        taskList.add(event);
    }
}
