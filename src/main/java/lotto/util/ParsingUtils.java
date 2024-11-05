package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.view.ErrorMessage;

public class ParsingUtils {

    public static int parseStringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static List<Integer> parseStringToIntegerList(String input) {
        try {
            return splitAndParseToList(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_FORMAT_INVALID.getMessage());
        }
    }

    private static List<Integer> splitAndParseToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private ParsingUtils() {
        // 인스턴스화 방지
    }
    
}
