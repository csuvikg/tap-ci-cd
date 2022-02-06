package com.infinitelambda.tapcicd;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Utils {
    private Utils() {
      // Should not be instantiated
    }

    public static String normalize(String str) {
        return Arrays.stream(str.split(" "))
                .filter(Predicate.not(String::isBlank))
                .map(String::toLowerCase)
                .map(w -> Character.toUpperCase(w.charAt(0)) + w.substring(1))
                .collect(Collectors.joining(" "));
    }
}
