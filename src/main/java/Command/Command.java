package Command;

import Task.TaskList;

public abstract class Command {
    public abstract CommandType getType();

    public abstract void execute(TaskList taskList);
}
