package com.me.common.logs.log4j;

import org.apache.log4j.Logger;

public class Log4j1xDemo {
    
    public static Logger logger = Logger.getLogger(Log4j1xDemo.class);
    public static Logger qosActionLogger = Logger.getLogger("qosActionLogger");
    public static Logger qosCrashLogger = Logger.getLogger("qosCrashLogger");
    
    public static void main(String[] args) {
//        logger.debug("debug message...");
        logger.info("info message...");
        logger.error("error message...");
        
        qosActionLogger.info("info message of action log");
        qosCrashLogger.info("info message of crash log");
    }
}
