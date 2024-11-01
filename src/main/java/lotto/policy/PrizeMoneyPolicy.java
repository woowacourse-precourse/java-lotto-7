package lotto.policy;

import java.util.List;
import java.util.stream.Stream;

public enum PrizeMoneyPolicy {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOTHING(0,0);

    private final int matchedNumberCount;
    private final long priceMoney;

    PrizeMoneyPolicy(int matchedNumberCount, long priceMoney){
        this.matchedNumberCount = matchedNumberCount;
        this.priceMoney = priceMoney;
    }

    public static List<PrizeMoneyPolicy> getPrizeMoney(int matchedNumberCount){
        if(matchedNumberCount == 5){
            return List.of(SECOND, THIRD);
        }
        if(matchedNumberCount == 0){
            return List.of(NOTHING);
        }
        return Stream.of(FIRST, FOURTH, FIFTH)
                .filter(rank -> rank.matchedNumberCount == matchedNumberCount)
                .toList();
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public long getPriceMoney() {
        return priceMoney;
    }
}
