package Dan.Command;

import Dan.Task.TaskList;
import Dan.Task.Task;
import Dan.Ui.Ui;

public class MarkCommand extends Command {
    int index;

    public MarkCommand(int i) {
        this.index = i;
    }

    public CommandType getType() {
        return CommandType.MARK;
    }

    public boolean execute(TaskList taskList, Ui ui) {
        taskList.mark(index);
        Task task = taskList.getTask(index);
        ui.mark(task, taskList.size());
        return true;
    }
}
