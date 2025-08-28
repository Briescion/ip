package Dan.Command;

import Dan.Task.TaskList;
import Dan.Task.Task;

import Dan.Ui.Ui;

public class EventCommand extends Command {
    Task event;

    public EventCommand(Task e) {
        this.event = e;
    }

    public CommandType getType() {
        return  CommandType.EVENT;
    }

    public boolean execute(TaskList taskList, Ui ui) {
        taskList.add(event);
        ui.makeTask(event, taskList.size());
        return true;
    }
}
