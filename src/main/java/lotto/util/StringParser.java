package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    private StringParser() {
    }

    public static List<Integer> parseToIntegerList(List<String> input) {
        return input.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}

