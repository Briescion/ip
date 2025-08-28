package Command;

import Task.TaskList;

public class MarkCommand extends Command {
    int index;

    public MarkCommand(int i) {
        this.index = i;
    }

    public CommandType getType() {
        return CommandType.MARK;
    }

    public void execute(TaskList taskList) {
        taskList.markDone(index);
    }
}
