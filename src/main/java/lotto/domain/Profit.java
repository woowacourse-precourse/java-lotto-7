package lotto.domain;

import static lotto.util.LottoConstants.LOTTO_PRICE;

public class Profit {
    private final LottoResult lottoResult;
    private final LottoCount lottoCount;
    private final static int PERCENT = 100;

    public Profit(LottoResult lottoResult, LottoCount lottoCount) {
        this.lottoResult = lottoResult;
        this.lottoCount = lottoCount;
    }

    public double calculateTotalProfit() {
        return (getWinningPrize() / getPurchasedPrice()) * PERCENT;
    }

    private double getPurchasedPrice() {
        return lottoCount.getCount() * LOTTO_PRICE.getValue();
    }

    private double getWinningPrize() {
        return lottoResult.calculateWinningPrize();
    }
}
