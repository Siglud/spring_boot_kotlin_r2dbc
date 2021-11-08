package org.acgeek.jerk.java9;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TypeHintTest {
    @Test
    void typeHint() {
        var a = List.of(1, 2 , 3, 4);
        for (var b : a) {
            System.out.println(b);
        }
        var c = new ArrayList<Integer>();
        c.add(1);
        System.out.println(c);
    }
}
