package lotto.infrastructure.util;

import static lotto.infrastructure.exception.ErrorCode.*;

import java.util.Arrays;
import java.util.List;

public class NumberParser {

    public static List<Integer> parseLottoNumbers(String numbers) {
        try {
            return Arrays.stream(numbers.split(","))
	.map(String::trim)
	.map(Integer::parseInt)
	.toList();
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public static int parseBonusNumber(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }
}
