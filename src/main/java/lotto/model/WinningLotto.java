package lotto.model;

import static lotto.constant.LottoConstants.NUMBER_COUNT;

import lotto.exception.DuplicateLottoNumberException;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validateDuplicateNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(Lotto lotto, BonusNumber bonusNumber) {
        if (isContainsBonusNumberInLotto(lotto, bonusNumber)) {
            throw new DuplicateLottoNumberException();
        }
    }

    private boolean isContainsBonusNumberInLotto(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    public Rank calculateRank(Lotto lotto) {
        return Rank.of(matchCount(lotto), containsBonusNumber(lotto));
    }

    private int matchCount(Lotto lotto) {
        int matchCount = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (this.lotto.getNumbers().contains(lotto.getNumber(i))) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean containsBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }
}
