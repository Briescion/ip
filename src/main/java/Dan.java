import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Dan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String markRegex =  "^mark (-?\\d+)$";
        String divider = "____________________________________________________________ ";
//        TaskList taskList = new TaskList();
        ArrayList<Task> taskList = new ArrayList<>();

        System.out.println("Hello! I'm Dan\n");
        System.out.println("What can I do for you?\n");
        System.out.println(divider);

        String input = "";

        while(!input.equals( "bye")) {
            input = scanner.nextLine();

            System.out.println(divider);

            if(input.equals("list")) {
                for(int i = 1; i < taskList.size() + 1; i++) {
                    System.out.println(i + ".[" + taskList.get(i - 1).getStatusIcon() + "] " + taskList.get(i - 1));
                }
            } else if(input.matches(markRegex)){
                String[] temp = input.split(" ");
                int index = Integer.parseInt(temp[1]);
                Task task =  taskList.get(index - 1);
                task.markDone();
                System.out.println("Nice! I've marked this task as done: \n [X] " + task);
            } else {
                    taskList.add(new Task(input));
                    System.out.println("added: " + input);
            }

            System.out.println(divider);
        }

        System.out.println("Bye. Hope to see you again soon!\n");
        System.out.println(divider);
    }
}
