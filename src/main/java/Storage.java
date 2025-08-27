import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    Path filePath, dirPath;

    public Storage() {
        String filePathString = "data.Dan.txt";
        String dirPathString = "data";

        this.filePath = Paths.get(filePathString);
        this.dirPath = Paths.get(dirPathString);

        File data = filePath.toFile();
        File dir = dirPath.toFile();

        if (!dir.isDirectory()) {
            try {
                Files.createDirectory(dirPath);
            } catch(IOException e) {

            }
        }

        if (!data.isFile()) {
            try {
                Files.createFile(filePath);
            } catch(IOException e) {

            }
        }
    }

     public ArrayList<String> getData() {
        ArrayList<String> dataArr = new ArrayList<>();
         try {
             File dataFile = this.filePath.toFile();
             Scanner s = new Scanner(dataFile);
             while (s.hasNext()) {
                 dataArr.add(s.nextLine());
             }

             return dataArr;
         } catch (FileNotFoundException e) {
             return dataArr;
         }
    }

    public void writeData(ArrayList<Task> tasks) {
        try {
            File dataFile = this.filePath.toFile();
            FileWriter fw = new FileWriter(dataFile);

            String data = "";

            for (int i = 0; i < tasks.size(); i++) {
               data = data + formatTaskToText(tasks.get(i)) + System.lineSeparator();
            }

            fw.write(data);
        } catch (IOException e) {

        }
    }

    private String formatTaskToText(Task task) {
        String data = "";
        switch (task.getTaskType()) {
            case TODO:
                ToDo todo = (ToDo) task;
                data += "T | ";
                data += todo.isDone().toString() + " | ";
                data += todo.getDescription();
            case EVENT:
                Event event = (Event) task;
                data += "E | ";
                data += event.isDone().toString() + " | ";
                data += event.getDescription() + " | ";
                data += event.getDuration();
            case DEADLINE:
                Deadline deadline = (Deadline) task;
                data += "D | ";
                data += deadline.isDone().toString() + " | ";
                data += deadline.getDescription() + " | ";
                data += deadline.getDeadline();
        }

        return data;
    }
}
