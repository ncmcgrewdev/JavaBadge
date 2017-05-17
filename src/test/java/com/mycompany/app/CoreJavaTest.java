package com.mycompany.app;

import com.mycompany.app.core.CoreJava;
import junit.framework.TestCase;
import org.apache.log4j.BasicConfigurator;

/**
 * Created by ncmcgrew on 5/15/2017.
 */
public class CoreJavaTest extends TestCase {
    public void testAscendingFile() throws Exception {
        BasicConfigurator.configure();
        CoreJava.ascendingFile();
    }

    public void testDescendingFile() throws Exception {
        BasicConfigurator.configure();
        CoreJava.descendingFile();
    }

    public void testMaxString() throws Exception {
        BasicConfigurator.configure();
        CoreJava.maxString();
    }
}