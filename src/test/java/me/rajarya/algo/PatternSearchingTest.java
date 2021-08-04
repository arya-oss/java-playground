package me.rajarya.algo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PatternSearchingTest {

    @ParameterizedTest
    @ValueSource(strings = {"int", "float", "double", "long"})
    public void testPatternArePresentInAText(String pattern) {
        String text = "java datatypes are int, bool, double, float, long";
        PatternSearching ps = new PatternSearching();
        assertTrue(ps.checkPattern(pattern, text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"boolean", "number"})
    public void testPatternAreNotPresentInAText(String pattern) {
        String text = "java datatypes are int, bool, double, float, long";
        PatternSearching ps = new PatternSearching();
        assertFalse(ps.checkPattern(pattern, text));
    }
}
