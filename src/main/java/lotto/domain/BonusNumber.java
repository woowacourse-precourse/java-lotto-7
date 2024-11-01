package lotto.domain;

import lotto.exception.bonus.BonusErrorMessages;

import java.util.List;

public class BonusNumber {
    private final int number;

    public BonusNumber(String input, List<Integer> winningNumbers) {
        this.number = parseAndValidate(input, winningNumbers);
    }

    private int parseAndValidate(String input, List<Integer> winningNumbers) {
        checkIsPositiveInteger(input);

        int number = Integer.parseInt(input);
        checkRange(number);
        checkNotDuplicate(number, winningNumbers);

        return number;
    }

    private void checkIsPositiveInteger(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException(BonusErrorMessages.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private void checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(BonusErrorMessages.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    private void checkNotDuplicate(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(BonusErrorMessages.DUPLICATE_NUMBER.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
