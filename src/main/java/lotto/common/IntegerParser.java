package lotto.common;

import static lotto.common.ExceptionMessage.INVALID_NUMBER_FORMAT;

import java.util.List;

public class IntegerParser {
    public static int parseToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static List<Integer> parseStringListToIntList(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
