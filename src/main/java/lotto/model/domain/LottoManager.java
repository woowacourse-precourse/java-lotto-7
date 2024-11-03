package lotto.model.domain;

import static lotto.message.ErrorMessage.BONUS_NUMBER_DUPLICATE;
import static lotto.message.ErrorMessage.INVALID_BONUS_NUMBER_RANGE;

public class LottoManager {

    private Lotto winningLotto;
    private Integer bonusNumber;

    public Lotto saveWinningLotto(Lotto winningLotto) {
        return this.winningLotto = winningLotto;
    }

    public Integer saveBonusNumber(Integer bonusNumber) {
        validateBonusNumberDuplication(bonusNumber);
        validateRange(bonusNumber);
        return this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberDuplication(Integer bonusNumber) {
        if (winningLotto != null && winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    private void validateRange(Integer number) {
        if (!isNumbersInRange(number)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isNumbersInRange(Integer number) {
        return number >= 1 && number <= 45;
    }
}