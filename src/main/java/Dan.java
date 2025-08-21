import java.util.Scanner;

public class Dan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String divider = "____________________________________________________________ ";

        System.out.println("Hello! I'm Dan\n");
        System.out.println("What can I do for you?\n");
        System.out.println(divider);

        String input = "";
        while(!input.equals( "bye")) {
            input = scanner.nextLine();
            System.out.println(divider);
        }

        System.out.println("Bye. Hope to see you again soon!\n");
        System.out.println(divider);
    }
}
