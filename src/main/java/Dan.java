import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Dan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String markRegex =  "^mark (-?\\d+)$";
        String toDoRegex = "^todo (.+)$";
        String deadlineRegex = "^deadline (.+) /by (.+)$";
        String eventRegex = "^event (.+) /from (.+) /to (.+)$";
        String divider = "____________________________________________________________ ";

        ArrayList<Task> taskList = new ArrayList<>();

        System.out.println("Hello! I'm Dan\n");
        System.out.println("What can I do for you?\n");
        System.out.println(divider);

        String input = "";

        while (!input.equals( "bye")) {
            input = scanner.nextLine();

            System.out.println(divider);

            if (input.equals("list")) {
                for(int i = 1; i < taskList.size() + 1; i++) {
                    System.out.println(i + "." + taskList.get(i - 1));
                }
            } else if (input.matches(markRegex)){
                String[] temp = input.split(" ");
                int index = Integer.parseInt(temp[1]);
//                try {
                    Task task =  taskList.get(index - 1);
                    task.markDone();
                    System.out.println("Nice! I've marked this task as done: \n " + task);
//                } catch(IndexOutOfBoundsException e) {

//                }
            } else if (input.matches(toDoRegex)){
                String desc = input.replaceFirst("todo", "");
//                String[] temp = input.split("todo", 1);
//                if (temp.length != 1) {
//                    continue;
//                }
//
//                String desc = temp[0];
                ToDo t = new ToDo(desc);
                taskList.add(t);
                System.out.println("Got it. I've added this task: \n " + t + "\nNow you have " + taskList.size() + " tasks in the list.");
            } else if (input.matches(eventRegex)) {
                String trim = input.replaceFirst("event", "");
                String[] fromSplit = trim.split("/from", 2);
                if (fromSplit.length == 2) {
                    String desc = fromSplit[0];
                   String duration = fromSplit[1];
                   String[] times = duration.split("/to", 2);

                   if (times.length != 2) {
                       continue;
                   }

                   String from = times[0];
                   String to = times[1];
                   Event e = new Event(desc, from, to);
                   taskList.add(e);

                    System.out.println("Got it. I've added this task: \n " + e + "\nNow you have " + taskList.size() + " tasks in the list.");
                }
            } else if (input.matches(deadlineRegex)){
                String trim = input.replaceFirst("deadline", "");
                String[] temp = trim.split("/by", 2);
                if (temp.length != 2) {
                    continue;
                }
                String desc = temp[0];
                String by = temp[1];

                Deadline d = new Deadline(desc, by);
                taskList.add(d);
                System.out.println("Got it. I've added this task: \n " + d + "\nNow you have " + taskList.size() + " tasks in the list.");
            } else {
                System.out.println("Unrecognised input");
            }
            System.out.println(divider);
        }

        System.out.println("Bye. Hope to see you again soon!\n");
        System.out.println(divider);
    }
}
