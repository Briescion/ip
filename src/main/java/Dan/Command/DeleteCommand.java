package Command;

import Task.Task;
import Task.TaskList;

import Ui.Ui;

public class DeleteCommand extends Command {
    int index;

    public DeleteCommand(int i) {
        this.index = i;
    }

    public CommandType getType() {
        return  CommandType.DELETE;
    }

    public boolean execute(TaskList taskList, Ui ui) {
        Task task = taskList.getTask(index);
        taskList.delete(index);
        ui.deleteTask(task, taskList.size());
        return true;
    }
}
