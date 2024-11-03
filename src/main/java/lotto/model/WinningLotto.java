package lotto.model;

import lotto.exception.ErrorMessage;
import lotto.exception.GameException;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validateDuplicateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank calculateRank(Lotto lotto) {
        int matchCount = calculateMatchCount(lotto);
        boolean isMatchBonusNumber = lotto.isContain(bonusNumber.getNumber());
        return Rank.of(matchCount, isMatchBonusNumber);
    }

    private void validateDuplicateBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.isContain(bonusNumber.getNumber())) {
            throw new GameException(ErrorMessage.HAS_DUPLICATE_NUMBER);
        }
    }

    private int calculateMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers()
            .stream()
            .filter(this.lotto::isContain)
            .count();
    }

}
