import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(args));

        if (args[0].equals(" ")){
            nothing();
        }
        else if(args[0].equals("-l")){
            listing();
        }
    }

    public static void nothing(){
        System.out.println("Command Line Todo application");
        System.out.println("=============================");
        System.out.println("Command line arguments:");
        System.out.println("    -l   Lists all the tasks");
        System.out.println("    -a   Adds a new task");
        System.out.println("    -r   Removes an task");
        System.out.println("    -c   Completes an task");
    }

    public static void listing() throws IOException {
        Path filePath = Paths.get("assets/tasks.txt");
        List<String> lines = Files.readAllLines(filePath);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(i+1 +" " +lines.get(i));
        }
    }
}
