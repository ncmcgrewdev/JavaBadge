package com.mycompany.app;

import com.google.gson.Gson;
import com.mycompany.app.XML_models.Note;
import junit.framework.TestCase;

/**
 * Created by ncmcgrew on 5/15/2017.
 */
public class StaticFileReaderTest extends TestCase {
    public void testGetXML(){
        Note note = new Note();
        note.setAllTheThings("Tove", "Jani","Reminder","Don\u0027t forget me this weekend!");
        assertEquals(StaticFileReader.getXML("sample.xml"), note);
    }

    public void testGetGson(){
        Note note = new Note();
        note.setAllTheThings("Tove", "Jani","Reminder","Don't forget me this weekend!");
        assertEquals(note, StaticFileReader.getGSON("sample.json"));
    }

    public void testJsonToFile(){
        Note note = new Note();
        note.setAllTheThings("Tove", "Jani","Reminder","Don't forget me this weekend!");
        StaticFileReader.toJsonFile(note);
    }

}