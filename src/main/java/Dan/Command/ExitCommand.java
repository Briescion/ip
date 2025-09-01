package Dan.Command;

import Dan.Task.TaskList;

public class ExitCommand extends Command {

    public CommandType getType() {
        return CommandType.EXIT;
    }

    @Override
    public String execute(TaskList taskList) {
        return "Bye. Hope to see you again soon!\n";
    }
}
