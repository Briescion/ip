package Dan.Command;

import Dan.Task.Task;
import Dan.Task.TaskList;
import Dan.Ui.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {
    String searchStr;

    public FindCommand(String searchStr) {
        this.searchStr = searchStr;
    }

    public CommandType getType() {
        return CommandType.EXIT;
    }

    @Override
    public boolean execute(TaskList taskList, Ui ui) {
        ArrayList<Task> searchResults = taskList.find(searchStr);
        ui.find(searchResults);
        return true;
    }
}
