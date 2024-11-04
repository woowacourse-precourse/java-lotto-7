package lotto;

import java.util.List;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_CONFLICT;

public class BonusNumber {

    int number;

    public BonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberConflict(bonusNumber, winningNumbers);
        this.number = bonusNumber;
    }

    private void validateBonusNumberConflict(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_CONFLICT.getValue());
        }
    }

    public int getNumber() {
        return number;
    }
}
