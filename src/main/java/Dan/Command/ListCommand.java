package Command;

import Task.TaskList;
import Ui.Ui;

public class ListCommand extends Command {
    public CommandType getType() {
        return  CommandType.LIST;
    }

    public boolean execute(TaskList taskList, Ui ui) {
        ui.list(taskList);
        return true;
    }
}
