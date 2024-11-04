package lotto.domain;

import static lotto.constans.ErrorMessages.ERROR_BONUS_NUMBER_RANGE;
import static lotto.constans.ErrorMessages.ERROR_DUPLICATE_BONUS_NUMBER;
import static lotto.constans.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constans.LottoConstants.MIN_LOTTO_NUMBER;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateNoDuplicateWithWinningNumbers(winningLotto, bonusNumber);
        validateBonusNumberRange(bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(Lotto userLotto) {
        return winningLotto.countMatchingNumbers(userLotto);
    }

    public boolean isBonusNumberMatched(Lotto userLotto) {
        return userLotto.containsNumber(bonusNumber);
    }

    private void validateNoDuplicateWithWinningNumbers(Lotto lotto, int bonusNumber) {
        if (lotto.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS_NUMBER);
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_RANGE);
        }
    }

}
