package Dan.Command;

import Dan.Task.TaskList;
import Dan.Task.Task;

import Dan.Ui.Ui;

public class ToDoCommand extends Command {
    Task toDo;

    public ToDoCommand(Task t) {
        this.toDo = t;
    }

    public CommandType getType() {
        return CommandType.TODO;
    }

    public boolean execute(TaskList taskList, Ui ui) {
        taskList.add(toDo);
        ui.makeTask(toDo, taskList.size());
        return true;
    }
}
