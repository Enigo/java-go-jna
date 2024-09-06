package org.example;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void testContains() {
        final var valuesToCheck = List.of("value1", "value2", "value3");
        final var valueToCheck = "value2";

        final var main = new Main();
        final var contains = main.containsGo(valuesToCheck, valueToCheck);

        Assertions.assertTrue(contains);
    }

    @Test
    void testDoesNotContain() {
        final var valuesToCheck = List.of("value1", "value2", "value3");
        final var valueToCheck = "missing";

        final var main = new Main();
        final var contains = main.containsGo(valuesToCheck, valueToCheck);

        Assertions.assertFalse(contains);
    }
}
