package lotto.domain;

import static lotto.handler.ConstantHandler.TOTAL_PERCENTAGE;

public class LottoProfit {
    private final float profit;

    public LottoProfit(int lottoMoney, int lottoPrize) {
        this.profit = calculateLottoProfit(lottoMoney, lottoPrize);
    }

    public float getLottoProfit() {
        return profit;
    }

    private float calculateLottoProfit(int money, int reward) {
        return (float) reward / money * TOTAL_PERCENTAGE;
    }
}
