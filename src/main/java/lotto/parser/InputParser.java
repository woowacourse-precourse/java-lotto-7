package lotto.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final String DELIMITER = ",";

    public static int parseInteger(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
