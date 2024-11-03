package lotto.model;

import static lotto.constant.LottoConstants.NUMBER_COUNT;

import lotto.exception.DuplicateLottoNumberException;

public record WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
    public WinningLotto {
        validateDuplicateNumber(lotto, bonusNumber);
    }

    private void validateDuplicateNumber(Lotto lotto, BonusNumber bonusNumber) {
        if (isContainsBonusNumberInLotto(lotto, bonusNumber)) {
            throw new DuplicateLottoNumberException();
        }
    }

    private boolean isContainsBonusNumberInLotto(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.numbers().contains(bonusNumber.number());
    }

    public Rank calculateRank(Lotto lotto) {
        return Rank.of(matchCount(lotto), containsBonusNumber(lotto));
    }

    private int matchCount(Lotto lotto) {
        int matchCount = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (this.lotto.numbers().contains(lotto.getNumber(i))) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean containsBonusNumber(Lotto lotto) {
        return lotto.numbers().contains(bonusNumber.number());
    }
}
