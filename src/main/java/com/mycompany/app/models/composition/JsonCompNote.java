package com.mycompany.app.models.composition;

import com.mycompany.app.models.BasicNote;

/**
 * Created by ncmcgrew on 5/17/2017.
 */
public class JsonCompNote {
    private BasicNote note;

    public JsonCompNote() {
    }

    public JsonCompNote(BasicNote note) {
        this.note = note;
    }

    public BasicNote getNote() {
        return note;
    }

    public void setNote(BasicNote note) {
        this.note = note;
    }
}
