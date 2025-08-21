import java.util.Scanner;

public class Dan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String divider = "____________________________________________________________ ";
        TaskList taskList = new TaskList();

        System.out.println("Hello! I'm Dan\n");
        System.out.println("What can I do for you?\n");
        System.out.println(divider);

        String input = "";
        while(!input.equals( "bye")) {
            input = scanner.nextLine();

            System.out.println(divider);
            if(input.equals("list")) {
                for(int i = 1; i < taskList.length() + 1; i++) {
                    System.out.println(i + ". " + taskList.getTaskName(i - 1));
                }
            } else {
                taskList.addTask(new Task(input));
                System.out.println("added: " + input);
            }

            System.out.println(divider);
        }

        System.out.println("Bye. Hope to see you again soon!\n");
        System.out.println(divider);
    }
}
