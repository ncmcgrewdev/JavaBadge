package com.mycompany.app;

/**
 * Created by ncmcgrew on 5/19/2017.
 */
public class BadEcapsulation {

    private String foo;
    private String bar;
    private String flip;
    private String flap;

    public BadEcapsulation() {
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public String getFlip() {
        return flip;
    }

    public void setFlip(String flip) {
        this.flip = flip;
    }

    public String getFlap() {
        return flap;
    }

    public void setFlap(String flap) {
        this.flap = flap;
    }
}
