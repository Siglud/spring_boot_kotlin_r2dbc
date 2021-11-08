package org.acgeek.jerk.java9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VarHandleSampleTest {

    public static class HandleTarget {
        public int count = 1;
    }

    private final HandleTarget handleTarget = new HandleTarget();
    private VarHandle varHandle;

    @BeforeEach
    public void setUp() throws Exception {
        this.varHandle = MethodHandles
                .lookup()
                .findVarHandle(HandleTarget.class, "count", int.class);
    }

    @Test
    void testGet() {
        assertEquals(1, this.varHandle.get(this.handleTarget));
        assertEquals(1, this.varHandle.getVolatile(this.handleTarget));
        assertEquals(1, this.varHandle.getOpaque(this.handleTarget));
        assertEquals(1, this.varHandle.getAcquire(this.handleTarget));
        assertEquals(1, this.varHandle.compareAndExchange(this.handleTarget, 1, 2));
        assertEquals(2, this.varHandle.compareAndExchange(this.handleTarget, 1, 3));
        assertEquals(2, this.varHandle.get(this.handleTarget));
    }
}
