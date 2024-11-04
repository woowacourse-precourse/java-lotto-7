package lotto.model;

import lotto.util.Parser;
import lotto.util.Validator;

import java.util.List;

import static lotto.common.ErrorMessage.*;

public class BonusNumber {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;
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
        checkWinningNumberRange(number);
        checkBonusNumberDuplicate(mainNumber.getNumbers(), number);
    }

    private void checkWinningNumberRange(int number) {
        if (number < RANGE_START || RANGE_END < number) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private void checkBonusNumberDuplicate(List<Integer> mainNumber, int bonusNumber) {
        if (mainNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_EXIST.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
