package lotto.utils;

import java.util.List;

public class NumberParser {
    private static final String ERROR_ONLY_NUMBER = "[ERROR] 숫자형식이 아닙니다.";

    public static List<Integer> parse(List<String> rawNumbers) {
        return rawNumbers.stream()
                .map(NumberParser::parse)
                .toList();
    }


    public static int parse(String promisingNumber) {
        try {
            return Integer.parseInt(promisingNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
    }
}
