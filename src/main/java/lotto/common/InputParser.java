package lotto.common;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String COMMA_DELIMITER = ",";
    private static final int DEFAULT_LIMIT = -1;

    public static Integer parseInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값입니다.");
        }
    }

    public static List<Integer> parseIntegers(final String input) {
        return Arrays.stream(input.split(COMMA_DELIMITER, DEFAULT_LIMIT))
                .map(String::trim)
                .map(InputParser::parseInteger)
                .toList();
    }
}
