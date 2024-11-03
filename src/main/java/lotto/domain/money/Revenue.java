package lotto.domain.money;

import lotto.domain.prize.LottoResult;

public class Revenue {

    private final Money revenue;
    private final double returns;

    public Revenue(LottoResult lottoResult, Money cost) {
        revenue = new Money(calculateRevenue(lottoResult));
        returns = calculateReturns(revenue, cost);
    }

    public Money getRevenue() {
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

    private double calculateReturns(Money revenue, Money money) {
        return (double) revenue.getMoney() / money.getMoney();
    }
}
