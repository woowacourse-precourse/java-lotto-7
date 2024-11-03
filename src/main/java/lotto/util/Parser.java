package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private Parser() {
    }

    private static final String DELIMITERS = ",";

    public static List<Integer> parseDelimitersInteger(String delimitedString) {
        try {
            return Arrays.stream(delimitedString.split(DELIMITERS))
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 들어와야합니다.");
        }
    }

    public static Long parseStringToLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효한 숫자가 입력되어야 합니다.");
        }
    }

    public static int parseStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효한 숫자가 입력되어야 합니다.");
        }
    }
}
