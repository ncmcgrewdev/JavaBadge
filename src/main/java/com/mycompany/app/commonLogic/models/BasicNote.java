package com.mycompany.app.commonLogic.models;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ncmcgrew on 5/15/2017.
 */
@Root
public class BasicNote {

    static final Logger logger = Logger.getLogger(BasicNote.class);

    public BasicNote() {
        super();
        BasicConfigurator.configure();
    }

    public BasicNote(String to, String from, String heading, String body) {
        BasicConfigurator.configure();
        this.to = to;
        this.from = from;
        this.heading = heading;
        this.body = body;
    }

    @Element
    private String to;

    @Element
    private String from;

    @Element
    private String heading;

    @Element
    private String body;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static Logger getLogger() {
        return logger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicNote note = (BasicNote) o;

        if (to != null ? !to.equals(note.to) : note.to != null) return false;
        if (from != null ? !from.equals(note.from) : note.from != null) return false;
        if (heading != null ? !heading.equals(note.heading) : note.heading != null) return false;
        return body != null ? body.equals(note.body) : note.body == null;
    }

    @Override
    public int hashCode() {
        int result = to != null ? to.hashCode() : 0;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (heading != null ? heading.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }
}
