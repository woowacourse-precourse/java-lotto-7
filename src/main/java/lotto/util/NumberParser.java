package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class NumberParser {
    private NumberParser() {
    }

    public static int parseIntegerFromString(final String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
