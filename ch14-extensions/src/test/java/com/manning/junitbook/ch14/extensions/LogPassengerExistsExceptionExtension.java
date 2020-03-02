package com.manning.junitbook.ch14.extensions;

import com.manning.junitbook.ch14.jdbc.PassengerExistsException;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.util.logging.Logger;

public class LogPassengerExistsExceptionExtension implements TestExecutionExceptionHandler {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (throwable instanceof PassengerExistsException) {
            logger.severe("Passenger exists:" + throwable.getMessage());
            return;
        }
        throw throwable;
    }
}
