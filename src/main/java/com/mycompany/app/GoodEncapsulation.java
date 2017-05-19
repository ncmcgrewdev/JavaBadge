package com.mycompany.app;

/**
 * Created by ncmcgrew on 5/19/2017.
 */
public class GoodEncapsulation {

    private String foo;
    private String bar;
    private String flip;
    private String flap;

    public GoodEncapsulation(String foo) {
        this.foo = foo;
        this.setStrings(foo);
    }

    public String getFoo() {
        return new String(foo);
    }

    public String getBar() {
        return new String(bar);
    }

    public String getFlip() {
        return new String(flip);
    }

    public String getFlap() {
        return new String(flap);
    }

    public void setStrings(String foo){
        this.foo = foo;
        this.bar = foo + " was a terrible choice for foo.";
        this.flip = "I think " + foo + " was a great choice for foo.";
        this.flap = "I think arguing about " + foo + " is a waste of time.";
    }
}
