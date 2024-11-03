package lotto.domain;

import static lotto.constant.ExceptionMessage.BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER;

import lotto.constant.Rank;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Number;

public class WinningLotto {

    private final Lotto winningLotto;
    private Number bonusNumber;

    public WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void setupBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = new Number(bonusNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER.getMessage());
        }
    }

    public Rank getRank(Lotto target) {
        int matchCount = (int)target.getNumbers().stream()
            .filter(winningLotto::contains)
            .count();
        boolean hasBonusNumber = target.getNumbers().contains(bonusNumber.get());
        return Rank.of(matchCount, hasBonusNumber);
    }
}
