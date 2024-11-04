package lotto.input;

import static lotto.constant.LottoConstants.NUMBER_SEPARATOR;
import static lotto.exception.ExceptionMessage.*;

import java.util.List;
import java.util.stream.Stream;
import lotto.util.InputUtil;

public class WinningNumberProcessor {

    private WinningNumberProcessor() {
    }

    public static List<Integer> processWinningNumbers(String input) {
        validateInput(input);
        return parseInputToList(input);
    }

    private static void validateInput(String input) {
        InputUtil.validateEmptyInput(input);

        if (input.trim().startsWith(NUMBER_SEPARATOR) || input.trim().endsWith(NUMBER_SEPARATOR)) {
            throw new IllegalArgumentException(INVALID_COMMA_POSITION.getMessage());
        }
    }

    private static List<Integer> parseInputToList(String input) {
        try {
            return Stream.of(input.split(NUMBER_SEPARATOR))
                    .map(String::trim)
                    .peek(InputUtil::validatePositiveInteger)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT.getMessage(), e);
        }
    }

}
