package com.mycompany.app.models.composition;

import com.google.gson.Gson;
import com.mycompany.app.StaticFileReader;
import com.mycompany.app.models.BasicNote;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;

/**
 * Created by ncmcgrew on 5/17/2017.
 */
public class CompNote {
    private BasicNote note;

    public CompNote(BasicNote note) {
        this.note = note;
    }

    public BasicNote getNote() {
        return note;
    }

    public void setNote(BasicNote note) {
        this.note = note;
    }

    public void writeNoteToFile(boolean json){
        String stringNote;
        String filename = "output";

        if(json){
            Gson gson = new Gson();
            stringNote = gson.toJson(note);
            filename += ".json";
        }
        else{
            stringNote = generateLinedNote();
            filename += ".txt";
        }

        try {
            StaticFileReader.writeToFile(filename, stringNote);
            note.getLogger().info("Note written to " + filename);
        } catch (FileNotFoundException e) {
            note.getLogger().error(e);
        }
    }

    private String generateLinedNote(){
        return "To: " + note.getTo() + "\n" +
                "From: " + note.getFrom() + "\n" +
                "Heading: " + note.getHeading() + "\n" +
                "Body: " + note.getBody();
    }


}
