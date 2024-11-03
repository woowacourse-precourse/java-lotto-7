package lotto.domain;

import static lotto.handler.ErrorHandler.INVALID_UNIQUE;

import java.util.List;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        validate(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        validateUnique(winningNumbers, bonusNumber);
        validateBonusNumber(bonusNumber);
    }

    private void validateUnique(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw INVALID_UNIQUE.getException();
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        validateNumberRange(bonusNumber);
    }
}

