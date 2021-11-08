package org.acgeek.jerk.java9;

import java.lang.System.Logger.Level;

import org.junit.jupiter.api.Test;

public class SystemLoggerTest {
    private static final System.Logger LOGGER = System.getLogger(SystemLoggerTest.class.getName());

    @Test
    void loggerTest() {
        LOGGER.log(Level.INFO, "run logger test");
    }
}
