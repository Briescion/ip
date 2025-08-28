package Dan.Command;

import Dan.Task.TaskList;
import Dan.Ui.Ui;

public class ExitCommand extends Command {

    public CommandType getType() {
        return CommandType.EXIT;
    }

    @Override
    public boolean execute(TaskList taskList, Ui ui) {
        ui.exit();
        return false;
    }
}
