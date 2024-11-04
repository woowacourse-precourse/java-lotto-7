package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    UNRANKED(0L,0,false),
    FIRST(2000_000_000L,6,false),
    SECOND(30_000_000L,5,true),
    THIRD(1_500_000L,5,false),
    FOURTH(50_000L,4,false),
    FIFTH(5_000L,3,false),;

    private long price;
    private int collectCount;
    private boolean requireBonusNumber;

    Ranking(long price, int collectCount, boolean requireBonusNumber) {
        this.price = price;
        this.collectCount = collectCount;
        this.requireBonusNumber = requireBonusNumber;
    }

    public static Ranking calcRank(int collectCount, boolean hasBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(rank -> isMatchingRank(collectCount, hasBonusNumber, rank))
                .findAny()
                .orElse(UNRANKED);
    }

    private static boolean isMatchingRank(int collectCount, boolean hasBonusNumber, Ranking rank) {
        return rank.collectCount == collectCount &&
                (!rank.requireBonusNumber || hasBonusNumber);
    }

    public long getPrice() {
        return price;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public boolean isRequireBonusNumber() {
        return requireBonusNumber;
    }
}
