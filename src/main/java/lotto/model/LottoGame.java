package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static lotto.validation.ValidatorImpl.ZERO;

public class LottoGame {
    public static final int ONE_HUNDRED = 100;
    public static final int TWO = 2;

    private final LottoResult lottoResult;
    private final int purchaseAmount;

    public LottoGame(int totalPurchaseAmount) {
        this.lottoResult = new LottoResult();
        this.purchaseAmount = totalPurchaseAmount;
    }

    public void addResult(Rank rank) {
        lottoResult.addRank(rank);
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public double calculateReturnRate() {
        int totalPrizeMoney = lottoResult.calculateTotalPrizeMoney();
        if (purchaseAmount == ZERO) {
            return ZERO;
        }
        double returnRate = ((double) totalPrizeMoney / purchaseAmount) * ONE_HUNDRED;
        return round(returnRate, TWO);
    }

    private double round(double value, int places) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void printReturnRate() {
        System.out.println("총 수익률은 " + calculateReturnRate() + "%입니다.");
    }
}
