package com.mycompany.app.core;

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
    /**
     * "Write an application to find out how many total characters
     * can be held in a list of strings before you run out of memory"
     */
    public static void maxString(){
        List<String> str_list = new ArrayList<>(20);
        long freeMem = Runtime.getRuntime().freeMemory();
        long totalMem = Runtime.getRuntime().totalMemory();
        System.out.println("free memory: "+freeMem);
        System.out.println("total memory: "+totalMem);

        //generate a ridiculously huge string
//        String foo = "a";
//        while(foo.length() < Integer.MAX_VALUE){
//            if(foo.getBytes().length > freeMem/2){
//                System.out.println(foo.length());
//                break;
//            }
//            foo += foo;
//        }
//
//        str_list.add(foo);
//
//        StringBuilder foobar = new StringBuilder(foo);

        while(true){
//            str_list.add(new String(foo)); // make sure you're allocating memory for a new string each time instead of just adding a pointer
            String foo = "a";
            while(foo.length() < Integer.MAX_VALUE){
                if(foo.getBytes().length > freeMem/2){
                    System.out.println(foo.length());
                    break;
                }
                foo += foo;
            }
            str_list.add(foo);
            System.out.println(getnumBytesInList(str_list));
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

        String[] reverseLines = new String[lineArray.length];
        for (int i = lineArray.length; i > 0 ; i--){
            reverseLines[lineArray.length - i] = lineArray[i - 1];
        }

        writeToFile("loremDescending.txt",reverseLines);
    }

    public static String[] getSortedFile(){

        String[] lineArray = readFileToStringArray("lorem.txt");

        if(lineArray == null) return null; // unchecked exception handling

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
            e.printStackTrace();
            return null;
        }
    }

    public static void writeToFile(String filename, String[] lines){
        try (PrintWriter writer = new PrintWriter(filename)){
            for (String line : lines) {
                writer.println(line);
            }

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
