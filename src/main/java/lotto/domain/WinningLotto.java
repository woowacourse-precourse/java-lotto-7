package lotto.domain;

import static lotto.message.ErrorMessage.DUPLICATE_BONUS_NUMBER;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto winningNumbers, BonusNumber bonusNumber) {
        validateDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto createWinningLotto(Lotto winngLotto, BonusNumber bonusNumber) {
        return new WinningLotto(winngLotto, bonusNumber);
    }

    public Rank getRank(Lotto lotto) {
        return Rank.calculateRank(winningNumbers.countSameNumbers(lotto), bonusNumber.hasBonusNumber(lotto));
    }

    private void validateDuplicate(Lotto lotto, BonusNumber bonusNumber) {
        if (bonusNumber.hasBonusNumber(lotto)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

}
