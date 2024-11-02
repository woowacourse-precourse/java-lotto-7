package lotto.model;

import static lotto.utils.Error.BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER;
import static lotto.utils.Error.BONUS_NUMBER_OUT_OF_RANGE;

import java.util.List;

public class BonusNumber {
    private static final Integer MINIMUM_NUMBER = 1;
    private static final Integer MAXIMUM_NUMBER = 45;
    private final int bonusNumber;

    public BonusNumber(WinningNumbers winningNumbers, int bonusNumber) {
        validateNumbersInRange(bonusNumber);
        validateNotDuplicatedWith(winningNumbers.getWinningNumbers(), bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateNumbersInRange(int bonusNumber) {
        if (bonusNumber < MINIMUM_NUMBER || MAXIMUM_NUMBER < bonusNumber) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE.getDescription());
        }
    }

    private void validateNotDuplicatedWith(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER.getDescription());
        }
    }
}
