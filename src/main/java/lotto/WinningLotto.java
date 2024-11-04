package lotto;

import static lotto.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.ErrorMessage.INVALID_BONUS_NUMBER_FORMAT;
import static lotto.LottoConstants.MAXIMUM_LOTTO_NUMBER;
import static lotto.LottoConstants.MINIMUM_LOTTO_NUMBER;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        checkBonusNumberRange(bonusNumber);
        checkDuplication(bonusNumber);
    }

    private void checkBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER)
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_FORMAT);
    }

    private void checkDuplication(int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER);
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
