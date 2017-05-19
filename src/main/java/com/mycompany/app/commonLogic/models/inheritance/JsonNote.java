package com.mycompany.app.commonLogic.models.inheritance;

import com.google.gson.Gson;

/**
 * Created by ncmcgrew on 5/17/2017.
 */
public class JsonNote extends LineNote{

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
