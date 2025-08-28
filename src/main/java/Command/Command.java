package Command;

import Task.TaskList;

import Ui.Ui;

public abstract class Command {
    public abstract CommandType getType();

    public abstract boolean execute(TaskList taskList, Ui ui);
}
