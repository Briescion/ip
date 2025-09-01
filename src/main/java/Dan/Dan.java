package Dan;

import Dan.Parser.Parser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import Dan.Storage.Storage;
import Dan.Task.TaskList;
import Dan.Command.Command;

public class Dan {

    private Storage storage;
    private TaskList tasks;

    public Dan(String filePath) {
        Path path = Paths.get( filePath);
        Storage storage = new Storage(path);
        this.storage = storage;
        this.tasks = new TaskList(storage.load());
    }

    public void run() {


        Scanner scanner = new Scanner(System.in);
        Boolean shouldContinue = true;
        String input = "";

        while (shouldContinue) {
            input = scanner.nextLine();

            try {
                Command cmd = Parser.parseUserInput(input);
//                shouldContinue = cmd.execute(this.tasks, ui);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

//    public static void main(String[] args) {
//        new Dan("data/tasks.txt").run();
//    }
    public String getReponse(String input) {
        try {
            Command cmd = Parser.parseUserInput(input);
//            shouldContinue = cmd.execute(this.tasks, ui);
            return cmd.execute(this.tasks);
        } catch (IllegalArgumentException e) {
            return "Invalid input";
        }
    }

    public static void unrecognisedInput() throws IllegalArgumentException {
        throw new IllegalArgumentException("I do not recognise this input.");
    }
}
