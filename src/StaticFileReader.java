import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by ncmcgrew on 5/15/2017.
 */
public class StaticFileReader {

    public static String readFileToMemory(String filename) throws FileNotFoundException {
        File file = new File(filename);

        Scanner scan = new Scanner(file);
        String result = "";

        while(scan.hasNextLine()){
            result += scan.nextLine();
        }

        return result;
    }

    public static void writeToFile(String filename, String content) throws FileNotFoundException {
        File file = new File(filename);
        PrintWriter writer = new PrintWriter(file);
        String[] lines = content.split("\n");

        for(String line : lines){
            writer.println(line);
        }

        writer.close();
    }
}
