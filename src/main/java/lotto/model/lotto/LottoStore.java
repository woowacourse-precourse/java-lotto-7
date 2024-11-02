package lotto.model.lotto;

public class LottoStore {
    private static final int LOTTO_PRICE = 1_000;

    public int calculateTicketsCount(int budget) {
        return budget / LOTTO_PRICE;
    }
}