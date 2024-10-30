package lotto.model;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;

    public int calculateLottoCount (int amount) {
        return amount / LOTTO_PRICE;
    }
}
