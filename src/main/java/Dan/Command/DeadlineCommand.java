package Dan.Command;

import Dan.Task.Task;
import Dan.Task.TaskList;

import Dan.Ui.Ui;

public class DeadlineCommand extends Command {
    Task deadline;

    public DeadlineCommand(Task d) {
        this.deadline = d;
    }

    public CommandType getType() {
        return  CommandType.DEADLINE;
    }

    public boolean execute(TaskList taskList, Ui ui) {
        taskList.add(deadline);
        ui.makeTask(deadline, taskList.size());
        return true;
    }
}
