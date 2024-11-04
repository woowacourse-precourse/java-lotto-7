package lotto.model;

import java.util.List;
import lotto.Lotto;
import lotto.constants.ErrorMessages;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(String userInputNumber, List<Integer> winningNumbers) {
        int number = convertToType(userInputNumber);
        validate(number, winningNumbers);
        this.bonusNumber = number;
    }

    public static BonusNumber from(String userInputNumber, List<Integer> winningNumbers) {
        return new BonusNumber(userInputNumber, winningNumbers);
    }

    private int convertToType(String userInputNumber) {
        try {
            return Integer.parseInt(userInputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NON_NUMERIC_VALUE.formatMessage());
        }
    }

    private void validate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_WITH_WINNING_NUMBER.formatMessage());
        }
        if (bonusNumber < Lotto.START_NUMBER || bonusNumber > Lotto.END_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_OUT_OF_RANGE.formatMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
