package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
            List<String> splitStrings = splitString(input);
            return splitStrings.stream()
                    .map(ParsingUtils::parseStringToInteger) // `parseStringToInteger` 활용
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_FORMAT_INVALID.getMessage());
        }
    }

    private static List<String> splitString(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private ParsingUtils() {
        // 인스턴스화 방지
    }
}
