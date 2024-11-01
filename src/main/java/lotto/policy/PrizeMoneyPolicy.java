package lotto.policy;

public enum PrizeMoneyPolicy {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(5, 5_000);

    private int matchedNumberCount;
    private long priceMoney;

    PrizeMoneyPolicy(int matchedNumberCount, long priceMoney){
        this.matchedNumberCount = matchedNumberCount;
        this.priceMoney = priceMoney;
    }
}
