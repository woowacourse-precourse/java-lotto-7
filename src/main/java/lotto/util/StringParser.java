package lotto.util;

import java.util.Arrays;
import java.util.List;

public abstract class StringParser {

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> toIntList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(StringParser::toInt)
                .toList();
    }
}
