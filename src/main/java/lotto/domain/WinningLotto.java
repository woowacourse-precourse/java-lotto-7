package lotto.domain;

import static lotto.message.ErrorMessage.DUPLICATE_BONUS_NUMBER;

public class WinningLotto {

    private final Lotto winngLotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto winngLotto, BonusNumber bonusNumber) {
        validateDuplicate(winngLotto, bonusNumber);
        this.winngLotto = winngLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto createWinningLotto(Lotto winngLotto, BonusNumber bonusNumber) {
        return new WinningLotto(winngLotto, bonusNumber);
    }

    public Rank getRank(Lotto lotto) {
        return Rank.calculateRank(winngLotto.countSameNumbers(lotto), bonusNumber.hasBonusNumber(lotto));
    }

    private void validateDuplicate(Lotto lotto, BonusNumber bonusNumber) {
        if (bonusNumber.hasBonusNumber(lotto)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

}
