package lotto.global.util;

import static lotto.global.enums.PrintMessage.*;

public class FormatValidator {
    private static final String PRICE_FORMAT = "^[1-9]+[0-9]*000$";
    private static final String WINNING_NUMBER_FORMAT = "^[0-9,]+$";
    private static final String BONUS_NUMBER_FORMAT = "^[0-9]+$";
    private static FormatValidator instance;

    public static FormatValidator getInstance() {
        if (instance == null) {
            instance = new FormatValidator();
        }
        return instance;
    }

    public void validatePriceFormat(String price) {
        if (!price.matches(PRICE_FORMAT)) {
            throw new IllegalArgumentException(PRICE_FORMAT_ERROR.getMessage());
        }
    }

    public void validateWinningNumberFormat(String numbers) {
        if (!numbers.matches(WINNING_NUMBER_FORMAT)) {
            throw new IllegalArgumentException(WINNING_NUMBER_FORMAT_ERROR.getMessage());
        }
    }

    public void validateBonusNumberFormat(String number) {
        if (!number.matches(BONUS_NUMBER_FORMAT)) {
            throw new IllegalArgumentException(BONUS_NUMBER_FORMAT_ERROR.getMessage());
        }
    }
}
