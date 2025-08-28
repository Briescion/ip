package Storage;

import Task.Task;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import Parser.Parser;

public class Storage {
    public static Storage shared = new Storage();
    public ArrayList<Task> taskList = new ArrayList<>();

    private final Path filePath =  Paths.get( "Data/Dan.txt");
    private final Path dirPath = Paths.get("Data");

    public Storage() {
        File data = filePath.toFile();
        File dir = dirPath.toFile();

        if (!dir.isDirectory()) {
            try {
                Files.createDirectory(dirPath);
            } catch(IOException e) {
                System.out.println("Could not create directory");
            }
        }

        if (!data.isFile()) {
            try {
                Files.createFile(filePath);
            } catch(IOException e) {
                System.out.println("Could not create file");
            }
        }

        try {
            List<String> dataStringList = Files.readAllLines(filePath);
            this.taskList = Parser.parseDataStringListToTasks(dataStringList);
            System.out.println("Initialised data");
        } catch(IOException e) {
            System.out.println("Could not access file");
        }
    }

    public ArrayList<String> getStringData() {
        ArrayList<String> dataArr = new ArrayList<>();
         try {
             List<String> lines = Files.readAllLines(filePath);
             ArrayList<String> linesArr = new ArrayList<>(lines);
             return linesArr;
         } catch (IOException e) {
             return dataArr;
         }
    }

    public ArrayList<Task> getTasks() {
        ArrayList<Task> tasks = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(filePath);
            ArrayList<String> linesArr = new ArrayList<>(lines);
            tasks = Parser.parseDataStringListToTasks(linesArr);
            return tasks;
        } catch (IOException e) {
            return tasks;
        }

    }

    public void writeData(ArrayList<Task> tasks) {
        try {
            File dataFile = filePath.toFile();
            FileWriter fw = new FileWriter(dataFile);

            String dataString = Parser.parseTasksToDataString(tasks);

            fw.write(dataString);
            fw.close();
            System.out.println("Wrote to file: " + dataString);
        } catch (IOException e) {
            System.out.println("Could not write to file.");
        }
    }
}
