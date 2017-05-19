package com.mycompany.app;

import com.mycompany.app.commonLogic.models.BasicNote;
import com.mycompany.app.commonLogic.models.StaticFileReader;
import junit.framework.TestCase;
import org.apache.log4j.BasicConfigurator;

/**
 * Created by ncmcgrew on 5/15/2017.
 */
public class StaticFileReaderTest extends TestCase {
    public void testGetXML(){
        BasicConfigurator.configure();
        BasicNote note = new BasicNote("Tove", "Jani","Reminder","Don\u0027t forget me this weekend!");
        assertEquals(StaticFileReader.getXML("sample.xml"), note);
    }

    public void testGetGson(){
        BasicConfigurator.configure();
        BasicNote note = new BasicNote("Tove", "Jani","Reminder","Don't forget me this weekend!");
        assertEquals(note, StaticFileReader.getGSON("sample.json"));
    }

    public void testJsonToFile(){
        BasicConfigurator.configure();
        BasicNote note = new BasicNote("Tove", "Jani","Reminder","Don't forget me this weekend!");
        StaticFileReader.toJsonFile(note);
    }

}