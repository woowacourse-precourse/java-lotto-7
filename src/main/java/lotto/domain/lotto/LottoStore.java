package lotto.domain.lotto;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    public int getLottoCount(String money) {
        return Integer.parseInt(money) / LOTTO_PRICE;
    }
}
