package com.mycompany.app;

/**
 * Created by ncmcgrew on 5/19/2017.
 */
public class OverloadConstructors {

    private String foo;
    private String bar;
    private String flip;
    private String flap;

    public OverloadConstructors() {
        this.bar = "";
        this.foo = "";
        this.flap = "";
        this.flip = "";
    }

    public OverloadConstructors(String foo) {
        this();
        this.foo = foo;
    }

    public OverloadConstructors(String foo, String bar) {
        this(foo);
        this.bar = bar;
    }

    public OverloadConstructors(String foo, String bar, String flip) {
        this(foo, bar);
        this.flip = flip;
    }

    public OverloadConstructors(String foo, String bar, String flip, String flap) {
        this(foo, bar, flip);
        this.flap = flap;
    }
}
