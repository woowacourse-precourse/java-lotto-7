package lotto.policy;

import java.util.stream.Stream;

public enum PrizeMoneyPolicy {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOTHING(0, 0);

    private final int matchedCount;
    private final long priceMoney;

    PrizeMoneyPolicy(int matchedCount, long priceMoney) {
        this.matchedCount = matchedCount;
        this.priceMoney = priceMoney;
    }

    public static PrizeMoneyPolicy getRank(int matchedCount, boolean bonusCount) {
        if (matchedCount == 5) {
            return secondOrThird(bonusCount);
        }

        if (matchedCount < 3) {
            return NOTHING;
        }

        return Stream.of(FIRST, FOURTH, FIFTH)
                .filter(rank -> rank.matchedCount == matchedCount)
                .toList().getFirst();
    }

    private static PrizeMoneyPolicy secondOrThird(boolean bonusCount) {
        if (bonusCount) {
            return SECOND;
        }
        return THIRD;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public long getPriceMoney() {
        return priceMoney;
    }
}
