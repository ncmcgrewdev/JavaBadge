package com.mycompany.app.core;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ncmcgrew on 5/15/2017.
 */
public class CoreJava {

    private CoreJava() {
    }

    static final Logger logger = Logger.getLogger(CoreJava.class);

    /**
     * "Write an application to find out how many total characters
     * can be held in a list of strings before you run out of memory"
     */
    public static void maxString(){
        List<String> str_list = new ArrayList<>(20);
        long freeMem = Runtime.getRuntime().freeMemory();
        long totalMem = Runtime.getRuntime().totalMemory();
        logger.info("free memory: "+freeMem);
        logger.info("total memory: "+totalMem);

        long i = 0;
        while(i < 2147483647){
            // generate a ridiculously huge string
            String foo = "a";
            while(foo.length() < Integer.MAX_VALUE){
                // cap string length at a high value to allow for more characters later
                if(foo.getBytes().length > freeMem/2){
                    logger.info(foo.length());
                    break;
                }
                foo += foo;
            }
            str_list.add(foo);
            logger.info(getnumBytesInList(str_list));
            i++;
        }
    }

    public static long getnumBytesInList(List<String> list){
        long result = 0;

        for(String str : list) result += str.length();

        return result;
    }

    /**
     * Write an application to read a file with 10k lines of text,
     * and output another file with the lines in sorted order
     */

    public static void ascendingFile(){
        writeToFile("loremAscending.txt", getSortedFile());
    }

    /**
     * Write an application to read a file with 10k lines of text,
     * and output another file with the lines in reverse sorted order
     */

    public static void descendingFile(){
        String[] lineArray = getSortedFile();

        if(lineArray != null){
            String[] reverseLines = new String[lineArray.length];
            for (int i = lineArray.length; i > 0 ; i--){
                reverseLines[lineArray.length - i] = lineArray[i - 1];
            }

            writeToFile("loremDescending.txt",reverseLines);
        }
    }

    public static String[] getSortedFile(){

        String[] lineArray = readFileToStringArray("lorem.txt");

        if(lineArray == null) return new String[]{}; // unchecked exception handling

        Arrays.sort(lineArray);

        return lineArray;
    }

    public static String[] readFileToStringArray(String filename){
        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)){
            List<String> lines = new ArrayList<>();
            while(scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }
            String[] result = new String[lines.size()];

            return lines.toArray(result);

        } catch (FileNotFoundException e) { // checked exception handling
            logger.error(e);
            return new String[]{};
        }
    }

    public static void writeToFile(String filename, String[] lines){
        try (PrintWriter writer = new PrintWriter(filename)){
            for (String line : lines) {
                writer.println(line);
            }

            writer.close();
        } catch (FileNotFoundException e) {
            logger.error(e);
        }
    }
}
