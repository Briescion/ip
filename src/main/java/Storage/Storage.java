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
    private Path filePath;
//    private final Path filePath =  Paths.get( "Data/Dan.txt");
//    private final Path dirPath = Paths.get("Data");

    public Storage(Path filePath) {
        this.filePath = filePath;
    }

    public boolean createDirectoriesAndFile() {
        try {
            Path parentDir = this.filePath.getParent();

            // Create parent directories if needed
            if (parentDir != null && !Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }

            if (!Files.exists(this.filePath)) {
                Files.createFile(this.filePath);
            }

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public Storage load() {
        if (createDirectoriesAndFile()) {
            return this;
         } else {
            return null;
        }
    }

    public ArrayList<Task> getTaskList() {
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
