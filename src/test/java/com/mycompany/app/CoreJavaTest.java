package com.mycompany.app;

import com.mycompany.app.core.CoreJava;
import junit.framework.TestCase;

/**
 * Created by ncmcgrew on 5/15/2017.
 */
public class CoreJavaTest extends TestCase {
    public void testAscendingFile() throws Exception {
        CoreJava.ascendingFile();
    }

    public void testDescendingFile() throws Exception {
        CoreJava.descendingFile();
    }

    public void testMaxString() throws Exception {
        CoreJava.maxString();
    }
}