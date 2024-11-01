package lotto.model;

public class LottoAmount {
    private static final int PRICE_PER_LOTTO = 1000;

    private final int amount;

    public LottoAmount(int purchasePrice) {
        this.amount = purchasePrice / PRICE_PER_LOTTO;
    }

    public int get() {
        return amount;
    }
}
