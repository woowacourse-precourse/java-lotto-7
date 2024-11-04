package lotto.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String INVALID_PARSE_INT_ERROR_MESSAGE = "[ERROR] 입력값에 대해 숫자로 입력해야합니다.";
    private static final String INVALID_CONVERT_STRING_ERROR_MESSAGE = "[ERROR] 입력 값은 쉼표(,)로 구분된 숫자여야 합니다.";
    private static final String STRING_FORMAT_PATTERN = "\\d+";
    private static final String DELIMITER = ",";

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PARSE_INT_ERROR_MESSAGE);
        }
    }

    public static List<Integer> convertStringToList(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim) // 각 요소의 양쪽 공백 제거
                .filter(part -> {
                    if (part.isEmpty() || !part.matches(STRING_FORMAT_PATTERN)) {
                        throw new IllegalArgumentException(INVALID_CONVERT_STRING_ERROR_MESSAGE);
                    }
                    return true;
                })
                .map(Integer::parseInt)
                .toList();
    }
}
