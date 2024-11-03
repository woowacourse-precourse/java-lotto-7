package lotto.model;

import lotto.exception.DuplicateLottoNumberException;

public final class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validateDuplicateNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(Lotto lotto, BonusNumber bonusNumber) {
        if (containsBonusNumberInLotto(lotto, bonusNumber)) {
            throw new DuplicateLottoNumberException();
        }
    }

    private boolean containsBonusNumberInLotto(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.containsLottoNumber(bonusNumber.getLottoNumber());
    }

    public Rank calculateRank(Lotto lotto) {
        return Rank.of(matchCount(lotto), containsBonusNumber(lotto));
    }

    private long matchCount(Lotto lotto) {
        return this.lotto.getNumbers().stream().filter(lotto.getNumbers()::contains).count();
    }

    private boolean containsBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getLottoNumber());
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
