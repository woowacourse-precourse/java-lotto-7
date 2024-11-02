package lotto.util.parser;

import static lotto.message.ErrorMessage.EMPTY_INPUT_BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.NOT_NUMERIC_BONUS_NUMBER_ERROR_MESSAGE;

public class BonusNumberParser {

    public static int parseRawBonusNumber(String rawBonusNumber) {

        validateRawBonusNumber(rawBonusNumber);
        int bonusNumber = 0;

        try {
            bonusNumber = Integer.parseInt(rawBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_BONUS_NUMBER_ERROR_MESSAGE.getContent());
        }

        return bonusNumber;
    }

    private static void validateRawBonusNumber(String rawBonusNumber) {
        if (rawBonusNumber.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_BONUS_NUMBER_ERROR_MESSAGE.getContent());
        }
    }
}
