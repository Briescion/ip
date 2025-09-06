package Dan.Command;

import Dan.Task.Task;
import Dan.Task.TaskList;

public class DeleteCommand extends Command {
    int index;

    public DeleteCommand(int i) {
        this.index = i;
    }

    public CommandType getType() {
        return  CommandType.DELETE;
    }

    public String execute(TaskList taskList) {
        assert index > 0;
        Task task = taskList.getTask(index);
        taskList.delete(index);
        return "Noted. I've removed this task: \n " + task + "\nNow you have " + taskList.size() + " tasks in the list.";
    }
}
