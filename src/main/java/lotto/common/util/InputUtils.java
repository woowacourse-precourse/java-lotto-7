package lotto.common.util;

import static lotto.common.exception.ErrorMessage.INPUT_NOT_INTEGER_ERROR;

import java.util.Arrays;
import java.util.List;

public class InputUtils {

    public static int parseStringToInt(String message) {
        try {
            return Integer.parseInt(message);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_INTEGER_ERROR.message());
        }
    }

    public static List<String> splitWithDelimiter(String message, String delimiter) {
        return Arrays.stream(message.split(delimiter))
                .map(String::strip)
                .toList();
    }
}
