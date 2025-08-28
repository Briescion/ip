package Command;

import Task.TaskList;
import Task.Task;
import Ui.Ui;

public class MarkCommand extends Command {
    int index;

    public MarkCommand(int i) {
        this.index = i;
    }

    public CommandType getType() {
        return CommandType.MARK;
    }

    public boolean execute(TaskList taskList, Ui ui) {
        taskList.markDone(index);
        Task task = taskList.getTask(index - 1);
        ui.mark(task, taskList.size());
        return true;
    }
}
