package Command;

import Task.TaskList;

public class ListCommand extends Command {
    public CommandType getType() {
        return  CommandType.LIST;
    }

    public void execute(TaskList taskList) {
        taskList.list();
    }
}
