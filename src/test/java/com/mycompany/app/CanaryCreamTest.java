package com.mycompany.app;

import junit.framework.TestCase;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Created by ncmcgrew on 5/19/2017.
 */
public class CanaryCreamTest extends TestCase {
    Logger logger = Logger.getLogger(CanaryCreamTest.class);
    public void testGetDescription() throws Exception {
        BasicConfigurator.configure();
        Pastry canary = new CanaryCream();

        logger.info(canary.getDescription());
    }

}