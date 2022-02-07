package com.infinitelambda.tapcicd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NormalizerServiceTest {
    @ParameterizedTest
    @ValueSource(strings = {"anonymous", "ANONYMOUS", "anonyMOUS"})
    void normalize_differentCaps_oneWord(String test) {
        // WHEN
        String result = Utils.normalize(test);

        // THEN
        assertEquals("Anonymous", result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello world", "HELLO WORLD", "heLLO woRLD"})
    void normalize_differentCaps_twoWords(String test) {
        // WHEN
        String result = Utils.normalize(test);

        // THEN
        assertEquals("Hello World", result);
    }

    @Test
    void normalize_multipleWords() {
        // GIVEN
        String test = "first second third fourth";

        // WHEN
        String result = Utils.normalize(test);

        // THEN
        assertEquals("First Second Third Fourth", result);
    }

    @Test
    void normalize_withSpaces() {
        // GIVEN
        String test = "too       much    spaces";

        // WHEN
        String result = Utils.normalize(test);

        // THEN
        assertEquals("Too Much Spaces", result);
    }

    @Test
    void normalize_withEmptyString() {
        // GIVEN
        String test = "";

        // WHEN
        String result = Utils.normalize(test);

        // THEN
        assertEquals("", result);
    }
}
