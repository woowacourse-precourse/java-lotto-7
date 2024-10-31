package lotto.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static List<Integer> parseToNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
