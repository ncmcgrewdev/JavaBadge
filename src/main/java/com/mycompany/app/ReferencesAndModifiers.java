package com.mycompany.app;

import java.util.List;

/**
 * Created by ncmcgrew on 5/19/2017.
 */
public class ReferencesAndModifiers {

    private static final String SECRET = "No, Luke, I am your father!";
    private static final String SEMI_SECRET = "Luke and Leia are siblings";

    private ReferencesAndModifiers() {
    }

    public static void foo(List<String> list, int num, final String str){
        list.set(0, "foo!");
        num += 10;
    }

    private static String getSecretString(){
        return SECRET;
    }

    public static String publishSecret(){
        return getSecretString();
    }

    protected static String getSemiSecretString(){
        return SEMI_SECRET;
    }
}
