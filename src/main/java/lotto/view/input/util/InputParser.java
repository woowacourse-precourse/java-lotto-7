package lotto.view.input.util;

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

    private static Integer parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE.getMessage());
        }
    }
}
