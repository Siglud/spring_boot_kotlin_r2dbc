package org.acgeek.jerk.java9;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ProcessHandlerTest {
    @Test
    void processTest() throws IOException {
        final ProcessBuilder processBuilder = new ProcessBuilder("top").inheritIO();
        final ProcessHandle processHandle = processBuilder.start().toHandle();
        processHandle.onExit().whenCompleteAsync((handle, throwable) -> {
            if (throwable == null) {
                System.out.println(handle.pid());
            } else {
                throwable.printStackTrace();
            }
        });
    }
}
