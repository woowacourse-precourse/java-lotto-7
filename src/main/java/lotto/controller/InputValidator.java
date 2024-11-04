package lotto.controller;

import static lotto.controller.ErrorMessages.INVALID_BONUS_NUMBER_FORMAT;
import static lotto.controller.ErrorMessages.INVALID_PAID_AMOUNT_FORMAT;
import static lotto.controller.ErrorMessages.INVALID_WINNING_NUMBERS_FORMAT;

public class InputValidator {

    private static final String REGEX_OF_POSITIVE_INTEGER = "^[1-9]\\d*$";
    private static final String REGEX_OF_VALID_WINNING_LOTTO_FORMAT = "^[1-9]\\d*(,[1-9]\\d*)*$";

    private InputValidator() {
    }

    public static void validatePaidAmount(String input) {
        if (!input.matches(REGEX_OF_POSITIVE_INTEGER)) {
            throw new IllegalArgumentException(INVALID_PAID_AMOUNT_FORMAT);
        }
    }

    public static void validateWinningNumbers(String input) {
        if (!input.matches(REGEX_OF_VALID_WINNING_LOTTO_FORMAT)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_FORMAT);
        }
    }

    public static void validateBonusNumber(String input) {
        if (!input.matches(REGEX_OF_POSITIVE_INTEGER)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_FORMAT);
        }
    }

}
