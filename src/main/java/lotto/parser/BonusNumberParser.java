package lotto.parser;

import static lotto.constants.ErrorMessages.*;

import lotto.validator.LottoNumberValidator;

public class BonusNumberParser {

    public static int parse(String input) {
        int bonusNumber = parseNumber(input);
        LottoNumberValidator.validateRange(bonusNumber);
        return bonusNumber;
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_NUMERIC);
        }
    }
}
