package com.mycompany.app.commonLogic.models;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
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

    private StaticFileReader() {
        /* Utility classes, which are a collection of static members, are not meant to be instantiated.
           Java adds an implicit public constructor to every class which does not define at least one explicitly.
           Hence, at least one non-public constructor should be defined.
         */
    }

    static final Logger logger = Logger.getLogger(StaticFileReader.class);

    public static String readFileToMemory(String filename) throws FileNotFoundException {
        File file = new File(filename);

        Scanner scan = new Scanner(file);
        StringBuilder builder = new StringBuilder();

        while (scan.hasNextLine()) {
            builder.append(scan.nextLine());
        }

        scan.close();

        return builder.toString();
    }

    public static void writeToFile(String filename, String content) throws FileNotFoundException {
        File file = new File(filename);
        PrintWriter writer = new PrintWriter(file);
        String[] lines = content.split("\n");

        for (String line : lines) {
            writer.println(line);
        }

        writer.close();
    }

    public static BasicNote getGSON(String filename) {
        try {
            String file = readFileToMemory(filename);
            Gson gson = new Gson();

            return gson.fromJson(file, BasicNote.class);

        } catch (FileNotFoundException e) {
            logger.error(e);
            return null;
        }
    }

    public static void toJsonFile(BasicNote note) {
        Gson gson = new Gson();
        try {
            writeToFile("note.json", gson.toJson(note));
        } catch (FileNotFoundException e) {
            note.getLogger().error(e);
        }
    }

    public static BasicNote getXML(String filename) {
        try {
            String file = readFileToMemory(filename);
            return readXMLfromString(file);
        } catch (FileNotFoundException e) {
            logger.error(e);
            return null;
        }
    }

    public static BasicNote readXMLfromString(String xml) {
        Serializer serializer = new Persister();
        BasicNote result;

        try {
            result =  serializer.read(BasicNote.class, xml);
        } catch (Exception e) {
            logger.error(e);
            result =  null;
        }

        return result;
    }

    public static void writeXMLtoFile(BasicNote note) {
        throw new UnsupportedOperationException();
    }
}