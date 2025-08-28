package Dan.Ui;

import Dan.Task.Task;
import Dan.Task.TaskList;

import java.util.ArrayList;

public class Ui {
    private final String DIVIDER = "____________________________________________________________ ";

//    public Ui() {}

    public void welcome() {
        System.out.println("Hello! I'm Dan\n");
        System.out.println("What can I do for you?\n");
        System.out.println(DIVIDER);
    }

    public void list(TaskList taskList) {
        System.out.println(DIVIDER);
        for(int i = 1; i < taskList.size() + 1; i++) {
            System.out.println(i + "." + taskList.getTask(i));
        }
        System.out.println(DIVIDER);
    }

    public void mark(Task task, int taskListSize) {
        System.out.println(DIVIDER);
        if (task.isDone()) {
            System.out.println("Got it. I've marked this task as done: \n " + task + "\n");
        } else {
            System.out.println("Got it. I've marked this task as undone: \n " + task + "\n");
        }
        System.out.println(DIVIDER);
    }

    public void makeTask(Task task, int taskListSize) {
        System.out.println(DIVIDER);
        System.out.println("Got it. I've added this task: \n " + task + "\nNow you have " + taskListSize + " tasks in the list.");
        System.out.println(DIVIDER);
    }

    public void deleteTask(Task task, int taskListSize) {
        System.out.println(DIVIDER);
        System.out.println("Noted. I've removed this task: \n " + task + "\nNow you have " + taskListSize + " tasks in the list.");
        System.out.println(DIVIDER);
    }

    public void find(ArrayList<Task> tasks) {
        System.out.println(DIVIDER);

        for(int i = 0; i < tasks.size(); i++) {
            System.out.println(i + 1 + "." + tasks.get(i));
        }

        System.out.println(DIVIDER);
    }

    public void exit() {
        System.out.println("Bye. Hope to see you again soon!\n");
        System.out.println(DIVIDER);
    }
}
