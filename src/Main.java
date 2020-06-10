import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        System.out.println(Arrays.toString(args));
        if (args.length == 0) {
            nothing();
        } else if(!(args[0].equals("-l")|| args[0].equals("-a")||args[0].equals("-r")||args[0].equals("-c"))){
            System.out.println("Undefined argument");
            nothing();
        } else if (args[0].equals("-l")) {
            listing();
        } else if (args[0].equals("-a")) {
            if (args.length == 1) {
                System.out.println("Unable to add: no task provided");
            } else
                addNewItem(args[1]);
        } else if (args[0].equals("-r")) {
            if (args.length == 1) {
                System.out.println("Unable to remove: no index provided");
            } else {
                removeItem(args[1]);
            }
        } else if(args[0].equals("-c")){
            if (args.length == 1) {
                System.out.println("Unable to remove: no index provided");
            } else {
                checkTask(args[1]);
            }
        }
    }


    public static void nothing() {
        System.out.println("Command Line Todo application");
        System.out.println("=============================");
        System.out.println("Command line arguments:");
        System.out.println("    -l   Lists all the tasks");
        System.out.println("    -a   Adds a new task");
        System.out.println("    -r   Removes an task");
        System.out.println("    -c   Completes an task");
    }

    public static void listing() throws IOException {
        Path filePath = Paths.get("../assets/tasks.txt");
        List<String> lines = Files.readAllLines(filePath);
        if (lines.size() > 0) {
            for (int i = 0; i < lines.size(); i++) {
                System.out.println(i + 1 + "- " + lines.get(i));
            }
        } else
            System.out.println("Nothing to do for today");
    }

    public static void addNewItem(String args) throws IOException {
        Path filePath = Paths.get("../assets/tasks.txt");
        List<String> newItem = Files.readAllLines(filePath);
        newItem.add("[ ]" + args);
        Files.write(filePath, newItem);
        System.out.println("Item added");
    }

    public static void removeItem(String args) throws IOException {
        Path filePath = Paths.get("../assets/tasks.txt");
        List<String> items = Files.readAllLines(filePath);
        int index = Integer.parseInt(args) - 1;
        if (items.size() >= 2) {
            items.remove(index);
            System.out.println("Item removed from " + (index + 1) + " . position");
            Files.write(filePath, items);
        }
    }

    public static void checkTask(String args) throws IOException {
        Path filePath = Paths.get("../assets/tasks.txt");
        List<String> items = Files.readAllLines(filePath);
        int index = Integer.parseInt(args) - 1;
        if (items.size() >= 2) {
            items.set(index, "[x" + items.get(index).substring(2));
            System.out.println("Task number " + index+1 + " is done.");
            Files.write(filePath, items);

        }
    }
}


