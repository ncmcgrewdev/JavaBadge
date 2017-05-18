package com.mycompany.app.models.inheritance;

import com.mycompany.app.StaticFileReader;
import com.mycompany.app.models.BasicNote;

import java.io.FileNotFoundException;

/**
 * Created by ncmcgrew on 5/17/2017.
 */
public class LineNote extends BasicNote {

    public void writeToFile(String filename){
        try {
            StaticFileReader.writeToFile(filename, this.toString());
        } catch (FileNotFoundException e) {
            this.getLogger().error(e);
        }
    }

    @Override
    public String toString() {
        return "To: " + getTo() + "\n" +
               "From: " + getFrom() + "\n" +
               "Heading: " + getHeading() + "\n" +
               "Body: " + getBody();
    }
}
