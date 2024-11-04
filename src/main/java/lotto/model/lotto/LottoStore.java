package lotto.model.lotto;

import static lotto.util.Constants.LOTTO_PRICE;

public class LottoStore {
    public int calculateTicketsCount(int budget) {
        return budget / LOTTO_PRICE;
    }
}