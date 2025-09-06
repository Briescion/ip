package Dan.Command;

import Dan.Task.Task;
import Dan.Task.TaskList;
import Dan.Task.TaskType;

public class DeadlineCommand extends Command {
    Task deadline;

    public DeadlineCommand(Task d) {
        this.deadline = d;
    }

    public CommandType getType() {
        return  CommandType.DEADLINE;
    }

    public String execute(TaskList taskList) {
        assert deadline.getTaskType() == TaskType.DEADLINE;
        taskList.add(deadline);
        return "Got it. I've added this task: \n " + deadline + "\nNow you have " + taskList.size() + " tasks in the list.";
    }
}
