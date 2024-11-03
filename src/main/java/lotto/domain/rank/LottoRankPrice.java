package lotto.domain.rank;

import lotto.domain.LottoPrice;

public class LottoRankPrice {

    private final int price;

    public LottoRankPrice(int lottoCount, boolean isBonus) {
        this.price = calculatePrice(lottoCount, isBonus);
    }

    public int getPrice() {
        return price;
    }

    private int calculatePrice(int lottoCount, boolean isBonus) {
        return LottoPrice.getByLottoCount(lottoCount, isBonus);
    }
}
