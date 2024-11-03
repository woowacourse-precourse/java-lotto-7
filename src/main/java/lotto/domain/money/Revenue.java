package lotto.domain.money;

import lotto.domain.prize.LottoResult;

public class Revenue {

    private static final int PERCENTAGE = 100;

    private final long revenue;
    private final double returns;

    public Revenue(LottoResult lottoResult, LottoMoney purchasedAmount) {
        revenue = calculateRevenue(lottoResult);
        returns = calculateReturns(revenue, purchasedAmount);
    }

    public long getRevenue() {
        return revenue;
    }

    public double getReturns() {
        return returns;
    }

    private long calculateRevenue(LottoResult lottoResult) {
        return lottoResult.getLottoResult().entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private double calculateReturns(long revenue, LottoMoney lottoMoney) {
        return (double) revenue / lottoMoney.getPurchasedAmount() * PERCENTAGE;
    }
}
