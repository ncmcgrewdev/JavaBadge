package com.mycompany.app;

import junit.framework.TestCase;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;

/**
 * Created by ncmcgrew on 5/22/2017.
 */
public class LoggingAppTest extends TestCase {

    LoggingApp foo = new LoggingApp.LoggingAppBuilder(10).msg("foo").build();

    public void testLogInfo(){
        foo.logInfo("bar");
    }

    public void testLogWarning(){
        foo.logWarning("BAR");
    }

    public void testLogError(){
        foo.logError("BAR!!!");
    }

    public void testLogDebug(){
        foo.logDebug("cantaloupe?");
    }

}