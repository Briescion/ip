package Dan.Command;

import Dan.Task.TaskList;

public class ListCommand extends Command {
    public CommandType getType() {
        return  CommandType.LIST;
    }

    public String execute(TaskList tasks) {
        String response = "";
        for(int i = 1; i < tasks.size() + 1; i++) {
            response += i + "." + tasks.getTask(i) + "\n";
        }
        return response;
    }
}
