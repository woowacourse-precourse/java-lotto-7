package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberArrayParser {
    private static final String DELIMITER = ",";

    private NumberArrayParser() {
    }

    public static List<Integer> parse(String input) {
        if (input.isEmpty()) {
            return new ArrayList<>();
        }

        return Arrays.stream(input.split(DELIMITER))
                .map(String::strip)
                .filter(NumberArrayParser::isNotEmpty)
                .map(NumberParser::parseInt)
                .toList();
    }

    private static boolean isNotEmpty(String name) {
        return !name.isEmpty();
    }
}
