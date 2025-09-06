package Dan.Command;

import Dan.Task.Task;
import Dan.Task.TaskList;

import java.util.ArrayList;

public class RemindCommand extends Command {
    int daysFromNow;

    public RemindCommand(int daysFromNow) {
        this.daysFromNow = daysFromNow;
    }

    public CommandType getType() {
        return CommandType.REMINDER;
    }

    public String execute(TaskList tasks) {
        ArrayList<Task> tasksToRemind = tasks.getTasksToRemind(daysFromNow);
        String response = "";

        for(int i = 0; i < tasksToRemind.size(); i++) {
            response += i + 1 + "." + tasksToRemind.get(i) + "\n";
        }

        return  response;
    }
}
