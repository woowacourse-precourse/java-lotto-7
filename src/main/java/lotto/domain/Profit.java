package lotto.domain;

public class Profit {
    private final Money money;
    private final LottoResult lottoResult;

    private Profit(Money money, LottoResult lottoResult) {
        this.money = money;
        this.lottoResult = lottoResult;
    }

    public static Profit of(Money money, LottoResult lottoResult) {
        return new Profit(money, lottoResult);
    }

    public double calculateProfit() {
        return (double) calculateTotalPrize() / money.getMoney() * 100;
    }

    private int calculateTotalPrize() {
        return lottoResult.calculateRankDistribution()
                .entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
