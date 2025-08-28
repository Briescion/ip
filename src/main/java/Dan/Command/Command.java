package Dan.Command;

import Dan.Task.TaskList;

import Dan.Ui.Ui;

public abstract class Command {
    public abstract CommandType getType();

    public abstract boolean execute(TaskList taskList, Ui ui);
}
