package lotto.util;

import lotto.constant.LottoConstants;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberParser {
    private NumberParser() {
        throw new AssertionError();
    }

    public static List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(LottoConstants.COMMA_DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
    }
}
