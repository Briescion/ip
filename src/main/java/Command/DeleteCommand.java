package Command;

import Task.Task;
import Task.TaskList;

public class DeleteCommand extends Command {
    int index;

    public DeleteCommand(int i) {
        this.index = i;
    }

    public CommandType getType() {
        return  CommandType.DELETE;
    }

    public void execute(TaskList taskList) {
        Task task = taskList.getTask(index);
        taskList.delete(index);
        System.out.println("Noted. I've removed this task: \n " + task + "\nNow you have " + taskList.size() + " tasks in the list.");
    }
}
