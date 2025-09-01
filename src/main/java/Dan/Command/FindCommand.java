package Dan.Command;

import Dan.Task.Task;
import Dan.Task.TaskList;

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
    public String execute(TaskList taskList) {
        ArrayList<Task> searchResults = taskList.find(searchStr);
        String response = "";

        for(int i = 0; i < searchResults.size(); i++) {
            response += i + 1 + "." + searchResults.get(i) + "\n";
        }
        return  response;
    }
}
