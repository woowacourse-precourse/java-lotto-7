package lotto.model;

import static lotto.constant.ErrorMessage.DUPLICATED_BONUS_NUMBER;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, final int bonusNumber) {
        validateLottoNotContainingBonusNumber(lotto, bonusNumber);
    }

    private void validateLottoNotContainingBonusNumber(Lotto lotto, final int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    public int countLottoNumberMatch(Lotto toCheck) {
        return lotto.countMatch(toCheck);
    }

    public boolean hasBonusNumberIn(Lotto toCheck) {
        return toCheck.contains(bonusNumber);
    }
}
