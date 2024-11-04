package lotto.model;

import lotto.util.Parser;
import lotto.util.Validator;

import static lotto.common.ErrorMessage.NOT_NUMBER_OR_RANGE_EXCESS;

public class BonusNumber {
    private final int number;

    public BonusNumber(final String inputValue, final MainNumber mainNumber) {
        int number = parseToInt(inputValue);
        validate(number, mainNumber);
        this.number = number;
    }

    private int parseToInt(final String inputValue) throws IllegalArgumentException {
        try {
            return Parser.parseStringToInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_OR_RANGE_EXCESS.getMessage());
        }
    }

    private void validate(int number, MainNumber mainNumber) throws IllegalArgumentException {
        Validator.checkWinningNumberRange(number);
        Validator.checkBonusNumberDuplicate(mainNumber.getNumbers(), number);
    }

    public int getNumber() {
        return number;
    }
}
