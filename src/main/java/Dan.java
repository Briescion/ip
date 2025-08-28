import Parser.Parser;

import java.util.Scanner;
import Task.TaskList;
import Command.Command;

public class Dan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String divider = "____________________________________________________________ ";

        TaskList taskList = new TaskList();

        System.out.println("Hello! I'm Dan\n");
        System.out.println("What can I do for you?\n");
        System.out.println(divider);

        String input = "";

        while (!input.equals( "bye")) {
            input = scanner.nextLine();

            System.out.println(divider);

            try {
                Command cmd = Parser.parseUserInput(input);
                cmd.execute(taskList);
            } catch (IllegalArgumentException e) {
                continue;
            }

            System.out.println(divider);
        }

        System.out.println("Bye. Hope to see you again soon!\n");
        System.out.println(divider);
    }

    public static void unrecognisedInput() throws IllegalArgumentException {
        throw new IllegalArgumentException("I do not recognise this input.");
    }
}
