package com.mycompany.app;

import java.util.List;

/**
 * Created by ncmcgrew on 5/19/2017.
 */
public class ReferencesAndModifiers {

    public static void foo(List<String> list, int num, final String str){
        list.set(0, "foo!");
        num +=10;
    }

    private static String getSecretString(){
        return "No, Luke, I am your father!";
    }

    public static String publishSecret(){
        return getSecretString();
    }

    protected static String getSemiSecretString(){
        return "Luke and Leia are siblings";
    }
}
