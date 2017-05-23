package com.mycompany.app;

/**
 * Created by ncmcgrew on 5/19/2017.
 */
public class Pastry {

    private String DESCRIPTIOIN ="A delightful treat that comes in a multitude of varieties";

    public String getDescription(){
        return DESCRIPTIOIN;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Pastry)) return false;
        Pastry pastry = (Pastry) obj;
        return this.getDescription().equals(pastry.getDescription());
    }
}
