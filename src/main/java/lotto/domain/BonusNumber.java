package lotto.domain;

import static lotto.domain.Lotto.MAX_LOTTO_NUMBER;
import static lotto.domain.Lotto.MIN_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;
import lotto.view.ErrorMessage;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumber(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        checkRange(bonusNumber);
        checkDuplicate(bonusNumber, winningNumbers);
    }

    private void checkRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.getMessage());
        }
    }

    private void checkDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        if (new HashSet<>(winningNumbers).contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATE_WITH_WINNING_NUMBERS.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
