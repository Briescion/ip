package Dan.Command;

import Dan.Task.TaskList;
import Dan.Task.Task;

public class MarkCommand extends Command {
    int index;

    public MarkCommand(int i) {
        this.index = i;
    }

    public CommandType getType() {
        return CommandType.MARK;
    }

    public String execute(TaskList taskList) {
        taskList.mark(index);
        Task task = taskList.getTask(index);

        if (task.isDone()) {
            return "Got it. I've marked this task as done: \n " + task + "\n";
        } else {
            return "Got it. I've marked this task as undone: \n " + task + "\n";
        }
    }
}
