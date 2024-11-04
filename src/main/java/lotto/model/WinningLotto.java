package lotto.model;

import lotto.exception.CustomException;
import lotto.exception.ErrorCode;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    private void validate(Lotto winningNumbers, int bonusNumber) {
        checkRange(bonusNumber);
        checkDuplication(winningNumbers, bonusNumber);
    }

    private void checkRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new CustomException(ErrorCode.INVALID_BONUS_RANGE);
        }
    }

    private void checkDuplication(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new CustomException(ErrorCode.DUPLICATE_BONUS);
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
