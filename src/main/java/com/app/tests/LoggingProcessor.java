package com.app.tests;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hans
 */
public class LoggingProcessor implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        Logger.getLogger(LoggingProcessor.class.getName()).log(Level.INFO, "Logging something");
        return true;
    }
}
