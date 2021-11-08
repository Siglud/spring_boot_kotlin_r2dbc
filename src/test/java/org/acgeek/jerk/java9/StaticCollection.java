package org.acgeek.jerk.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class StaticCollection {
    @Test
    void collectionTest() {
        var a = List.of();
        var b = List.of("Hello", "World");
        var c = List.of(1, 2, 3);
        var d = Set.of();
        var e = Set.of("Hello", "World");
        var f = Set.of(1, 2, 3);
        var g = Map.of();
        var h = Map.of("Hello", 1, "World", 2);
    }

}
