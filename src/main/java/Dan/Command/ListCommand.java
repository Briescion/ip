package Dan.Command;

import Dan.Task.TaskList;

public class ListCommand extends Command {
    public CommandType getType() {
        return  CommandType.LIST;
    }

    public String execute(TaskList taskList) {
        String response = "";
        for(int i = 1; i < taskList.size() + 1; i++) {
            response += i + "." + taskList.getTask(i) + "\n";
        }
        return response;
    }
}
