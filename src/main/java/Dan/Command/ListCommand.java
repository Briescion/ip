package Dan.Command;

import Dan.Task.TaskList;
import Dan.Ui.Ui;

public class ListCommand extends Command {
    public CommandType getType() {
        return  CommandType.LIST;
    }

    public boolean execute(TaskList taskList, Ui ui) {
        ui.list(taskList);
        return true;
    }
}
