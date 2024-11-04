package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static lotto.constants.LottoConstants.*;

public class LottoGame {

    private final LottoResult lottoResult;
    private final int purchaseAmount;

    public LottoGame(int purchaseAmount) {
        this.lottoResult = new LottoResult();
        this.purchaseAmount = purchaseAmount;
    }

    public void addResult(Rank rank) {
        lottoResult.addRank(rank);
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public double calculateRate() {
        long totalPrizeMoney = lottoResult.calculateTotalPrizeMoney();
        if (purchaseAmount == ZERO) {
            return ZERO;
        }
        return round(((double) totalPrizeMoney / purchaseAmount) * HUNDRED, TWO);
    }

    private double round(double value, int places) {
        BigDecimal roundedValue = BigDecimal.valueOf(value);
        return roundedValue.setScale(places, RoundingMode.HALF_UP).doubleValue();
    }
}
