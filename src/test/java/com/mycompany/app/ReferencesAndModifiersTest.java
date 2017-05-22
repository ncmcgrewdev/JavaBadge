package com.mycompany.app;

import junit.framework.TestCase;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ncmcgrew on 5/19/2017.
 */
public class ReferencesAndModifiersTest extends TestCase {
    Logger logger = Logger.getLogger(ReferencesAndModifiersTest.class);

    public void testFoo() throws Exception {

        List<String> foo = new ArrayList<>();
        foo.add("bar");

        final String str = "YOU SHALL NOT PASS!";

        int num = 32;

        logger.info(foo.get(0));

        ReferencesAndModifiers.foo(foo,num,str);

        logger.info(foo.get(0));
        logger.info(num);
        logger.info(str);
    }

    public void testSecret(){

        logger.info(ReferencesAndModifiers.publishSecret());
    }

    public void testSemiSecret(){
        BasicConfigurator.configure();

        logger.info(ReferencesAndModifiers.getSemiSecretString());
    }

}