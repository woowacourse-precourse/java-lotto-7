package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class LottoParser {

    private final static String NUMBER_DELIMITER = ",";
    private final static int NUMBERS_LENGTH = 6;

    public static List<Integer> parseBallNumbers(String input) {
        Set<String> collect = Arrays.stream(input.split(NUMBER_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toCollection(HashSet<String>::new));

        if (collect.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }

        return parseInt(collect);
    }

    private static List<Integer> parseInt(Set<String> collect) {
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
