package lotto.util;

import lotto.exception.InputErrorMessage;

public class InputParser {
    private static final String INTEGER_REGEX = "^[0-9]*$";

    private InputParser() {
    }

    public static int parseLottoPrice(String input) {
        validateLottoPrice(input);
        return Integer.parseInt(input);
    }

    private static void validateLottoPrice(String lottoPrice) {
        validateInputNullOrEmpty(lottoPrice);
        validateInputIsNumber(lottoPrice);
    }

    private static void validateInputNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(InputErrorMessage.INPUT_IS_EMPTY.getMessage());
        }
    }

    private static void validateInputIsNumber(String input) {
        if (input.matches(INTEGER_REGEX)) {
            return;
        }
        throw new NumberFormatException(InputErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
    }
}
