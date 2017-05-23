package com.mycompany.app;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Timestamp;

/**
 * Created by ncmcgrew on 5/22/2017.
 */
public class LoggingApp {

    private int val;
    private String msg;
    Timestamp timestamp;

    private LoggingApp(LoggingAppBuilder builder) {
        timestamp = new Timestamp(System.currentTimeMillis());
        this.val = builder.val;
        this.msg = builder.msg;
    }

    public void logInfo(String info){
        String log = String.format("timestamp=%s level=info message=%s value=%d info=%s", timestamp.toString(), msg, val, info);
        LogSingleton.getLogger().info(log);
    }

    public void logWarning(String warning){
        String log = String.format("timestamp=%s level=warning message=%s value=%d warning=%s", timestamp.toString(), msg, val, warning);
        LogSingleton.getLogger().warn(log);
    }

    public void logError(String error){

        String log = String.format("timestamp=%s level=error message=%s value=%d error=%s",timestamp.toString(), msg, val, error);
        LogSingleton.getLogger().error(log);
    }

    public void logDebug(String debug){
        String log = String.format("timestamp=%s level=debug message=%s value=%d info=%s", timestamp.toString(), msg, val, debug);
        LogSingleton.getLogger().debug(log);
    }

    public static class LoggingAppBuilder{
        private int val;
        private String msg;

        public LoggingAppBuilder(int val){
            this.val = val;
        }

        public LoggingAppBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public LoggingApp build(){
            return new LoggingApp(this);
        }
    }

    private static class LogSingleton {
        private static Logger logger;

        private LogSingleton(){
        }

        private static Logger getLogger(){
            if(logger == null){
                logger = Logger.getLogger(LoggingApp.class);
//                BasicConfigurator.configure();
                PropertyConfigurator.configure("log4j.properties");
            }
            return logger;
        }
    }
}
