package lotto.vo;

import lotto.util.Parser;
import lotto.util.Validator;

import java.util.List;

import static lotto.common.ErrorMessage.NOT_NUMBER_OR_RANGE_EXCESS;

public class BonusNumber {
    private final int number;

    public BonusNumber(final String inputValue) {
        int number = parseToInt(inputValue);
        validate(number);
        this.number = number;
    }

    private int parseToInt(final String inputValue) throws IllegalArgumentException {
        try {
            return Parser.parseStringToInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_OR_RANGE_EXCESS.getMessage());
        }
    }

    private void validate(int number) throws IllegalArgumentException {
        Validator.checkWinningNumberRange(number);
    }

    public int getNumber() {
        return number;
    }
}
