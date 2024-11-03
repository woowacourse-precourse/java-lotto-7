package lotto.utils;

import java.util.List;
import java.util.stream.Stream;

public class Parser {
    private final static String NUMBER_PARSE_ERROR = "[ERROR] 숫자로 입력해야 합니다.";
    private final static String SPLIT_NUMBER_ERROR = "[ERROR] 쉼표(,)로 구분된 숫자를 입력해야 합니다.";

    public static long stringToLong(String number) {
        try {
            return Long.parseLong(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_PARSE_ERROR);
        }
    }

    public static int stringToInt(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_PARSE_ERROR);
        }
    }

    public static List<Integer> splitNumbers(String rawWinNumbers) {
        try {
            return Stream.of(rawWinNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(SPLIT_NUMBER_ERROR);
        }
    }
}
