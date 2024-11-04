package lotto.infrastructure.util;

import static lotto.infrastructure.exception.ErrorCode.INVALID_LOTTO_NUMBER;

import java.util.Arrays;
import java.util.List;

public class NumberParser {

    private static final String DELIMITER = ",";

    public static List<Integer> parseLottoNumbers(String numbers) {
        try {
            return Arrays.stream(numbers.split(DELIMITER))
	.map(String::trim)
	.map(Integer::parseInt)
	.toList();
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public static int parseNumber(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }
}
