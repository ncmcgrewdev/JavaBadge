package com.mycompany.app;

import com.google.gson.Gson;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

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

        scan.close();

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

    public static BasicNote getGSON(String filename){
        try {
            String file = readFileToMemory(filename);
            Gson gson = new Gson();

            return gson.fromJson(file, BasicNote.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void toJsonFile(BasicNote note){
        Gson gson = new Gson();
        try {
            writeToFile("note.json", gson.toJson(note));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static BasicNote getXML(String filename){
        try{
            String file = readFileToMemory(filename);
            System.out.println(file);
            try{
                BasicNote note = readXMLfromString(file);
                return note;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BasicNote readXMLfromString(String xml) throws Exception {
        Serializer serializer = new Persister();

        return serializer.read(BasicNote.class, xml);
    }

    public static void writeXMLtoFile(BasicNote note){

    }
}