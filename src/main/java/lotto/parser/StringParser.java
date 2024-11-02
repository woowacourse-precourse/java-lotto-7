package lotto.parser;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public static List<Integer> numbers(final String input) {
        final String[] split = input.split(",");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .toList();
    }
}
