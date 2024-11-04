package lotto.purchase.domain;

import java.util.Map;
import lotto.lotto.domain.value.LottoRank;

public class PurchaseResult {
    private final Purchase purchase;
    private final double rateOfReturn;
    private final Map<LottoRank, Long> winningInfo;

    private PurchaseResult(Purchase purchase, double rateOfReturn, Map<LottoRank, Long> winningInfo) {
        this.purchase = purchase;
        this.rateOfReturn = rateOfReturn;
        this.winningInfo = winningInfo;
    }

    public static PurchaseResult of(Purchase purchase, long totalValue, Map<LottoRank, Long> winningInfo) {
        double rateOfReturn = purchase.getMoney().calculateRateOfIncome(totalValue);
        return new PurchaseResult(purchase, rateOfReturn, winningInfo);
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public Map<LottoRank, Long> getWinningInfo() {
        return winningInfo;
    }
}
