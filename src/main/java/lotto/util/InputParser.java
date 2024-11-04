package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.common.LottoConstants;

public class InputParser {

    private InputParser() {
    }

    public static List<Integer> parseToNumbers(String input) {
        return Arrays.stream(input.split(LottoConstants.WINNING_NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
