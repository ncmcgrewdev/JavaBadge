package com.mycompany.app;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ncmcgrew on 5/15/2017.
 */
@Root
public class BasicNote {

    public void setAllTheThings(String to, String from, String heading, String body) {
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
