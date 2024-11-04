package lotto.store.lotto.winner;

import lotto.money.Money;
import lotto.store.lotto.Lotto;

public enum LottoRank {
    FIRST(6, false,  2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    FAIL(Integer.MIN_VALUE, false, 0);

    private final int matchCountCondition;
    private final boolean bonusMatchCondition;
    private final Money price;

    LottoRank(int matchCountCondition, boolean bonusMatchCondition, int amount) {
        this.matchCountCondition = matchCountCondition;
        this.bonusMatchCondition = bonusMatchCondition;
        this.price = new Money(amount);
    }

    public Money price() {
        return price;
    }

    public int matchCountCondition() {
        return matchCountCondition;
    }

    public boolean bonusMatchCondition() {
        return bonusMatchCondition;
    }

    public boolean matches(WinningNumbers winningNumbers, Lotto lotto) {
        return matchCountCondition == winningNumbers.countMatch(lotto)
                && bonusMatchCondition == winningNumbers.isBonusMatch(lotto);
    }
}
