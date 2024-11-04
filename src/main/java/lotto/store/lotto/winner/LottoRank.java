package lotto.store.lotto.winner;

import lotto.money.Money;

public enum LottoRank {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    FAIL(0);

    private final Money price;
    LottoRank(int amount) {
        this.price = new Money(amount);
    }

    public Money price() {
        return price;
    }
}
