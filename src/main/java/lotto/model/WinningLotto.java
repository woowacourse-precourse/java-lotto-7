package lotto.model;

import lotto.exception.LottoValidationError;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(final Lotto lotto, final BonusNumber bonusNumber) {
        checkLottoContainsBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank calculateRank(final Lotto compareLotto) {
        final int matchedCount = lotto.countSameNumber(compareLotto);
        final boolean containsBonusNumber = compareLotto.contains(bonusNumber.value());
        return LottoRank.from(matchedCount, containsBonusNumber);
    }

    private void checkLottoContainsBonusNumber(final Lotto lotto, final BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber.value())) {
            LottoValidationError.LOTTO_NUMBERS_CONTAINS_BONUS_NUMBER.throwException();
        }
    }
}
