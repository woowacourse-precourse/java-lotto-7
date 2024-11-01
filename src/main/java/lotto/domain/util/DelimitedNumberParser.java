package lotto.domain.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class DelimitedNumberParser {

    public final static String NUMBER_DELIMITER = ",";
    public final static int NUMBERS_LENGTH = 6;

    private DelimitedNumberParser() {}

    public static List<Integer> parse(String input) {
        Set<String> collect = Arrays.stream(input.split(NUMBER_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toCollection(HashSet<String>::new));

        if (collect.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }

        return parseIntList(collect);
    }

    private static List<Integer> parseIntList(final Set<String> collect) {
        for (String s : collect) {
            if (!isNumeric(s)) {
                throw new IllegalArgumentException();
            }
        }

        return List.copyOf(collect.stream()
                .map(Integer::parseInt)
                .toList());
    }

    private static boolean isNumeric(String s) {
        return s.chars().allMatch(Character::isDigit);
    }
}
