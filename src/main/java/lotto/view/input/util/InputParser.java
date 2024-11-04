package lotto.view.input.util;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.ErrorMessage;

public final class InputParser {
    private InputParser() {
    }

    public static Integer parsePurchaseAmount(String input) {
        return parseInteger(input);
    }

    public static Integer parseWinningLottoBonusNumber(String input) {
        return parseInteger(input);
    }

    public static List<Integer> parseWinningLottoNumbers(String input) {
        return Stream.of(input.split(",", -1))
                .map(InputParser::parseInteger)
                .toList();
    }

    private static Integer parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE.getMessage());
        }
    }
}
