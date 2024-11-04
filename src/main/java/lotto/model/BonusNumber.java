package lotto.model;

import lotto.enums.BonusNumberErrorMessage;
import lotto.enums.LottoBoundInfo;

public class BonusNumber {
    private final int number;

    public BonusNumber(WinningNumbers winningNumbers, String rawInput) {
        validateIsNumber(rawInput);
        int number = Integer.parseInt(rawInput);
        validateIsElementInRange(number);
        validateIsNotDuplicate(winningNumbers, number);
        this.number = number;
    }

    public int getBonusNumber() {
        return number;
    }

    private void validateIsNumber(String rawInput) {
        if (!rawInput.matches("[0-9]+")) {
            throw new IllegalArgumentException(BonusNumberErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private void validateIsElementInRange(int number) {
        if (number > LottoBoundInfo.MAXIMUM_NUMBER.getInfo() || number < LottoBoundInfo.MINIMUM_NUMBER.getInfo()) {
            throw new IllegalArgumentException(BonusNumberErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private void validateIsNotDuplicate(WinningNumbers winningNumbers, int number) {
        if (winningNumbers.getWinningNumbers().contains(number)) {
            throw new IllegalArgumentException(BonusNumberErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

}
