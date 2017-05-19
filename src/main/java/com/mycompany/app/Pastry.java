package com.mycompany.app;

/**
 * Created by ncmcgrew on 5/19/2017.
 */
public class Pastry {

    public String getDescription(){
        return "A delightful treat that comes in a multitude of varieties";
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Pastry)) return false;
        Pastry pastry = (Pastry) obj;
        return this.getDescription().equals(pastry.getDescription());
    }
}
