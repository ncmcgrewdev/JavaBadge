package com.mycompany.app;

import junit.framework.TestCase;

/**
 * Created by ncmcgrew on 5/15/2017.
 */
public class StaticFileReaderTest extends TestCase {
    public void testGetXML(){
        BasicNote note = new BasicNote();
        note.setAllTheThings("Tove", "Jani","Reminder","Don\u0027t forget me this weekend!");
        assertEquals(StaticFileReader.getXML("sample.xml"), note);
    }

    public void testGetGson(){
        BasicNote note = new BasicNote();
        note.setAllTheThings("Tove", "Jani","Reminder","Don't forget me this weekend!");
        assertEquals(note, StaticFileReader.getGSON("sample.json"));
    }

    public void testJsonToFile(){
        BasicNote note = new BasicNote();
        note.setAllTheThings("Tove", "Jani","Reminder","Don't forget me this weekend!");
        StaticFileReader.toJsonFile(note);
    }

}