package Command;

import Task.Task;
import Task.TaskList;

public class DeadlineCommand extends Command {
    Task deadline;

    public DeadlineCommand(Task d) {
        this.deadline = d;
    }

    public CommandType getType() {
        return  CommandType.DEADLINE;
    }

    public void execute(TaskList taskList) {
        taskList.add(deadline);
    }
}
