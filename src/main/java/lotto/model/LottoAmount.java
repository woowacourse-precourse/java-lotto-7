package lotto.model;

import static lotto.model.constant.Lotto.PRICE_PER_LOTTO;

public class LottoAmount {
    private final int amount;

    public LottoAmount(final int purchasePrice) {
        this.amount = purchasePrice / PRICE_PER_LOTTO;
    }

    public int get() {
        return amount;
    }
}
