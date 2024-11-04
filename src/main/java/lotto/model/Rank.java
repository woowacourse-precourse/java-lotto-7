package lotto.model;

import lotto.constant.PrizeConstants;

public enum Rank {
    FIRST(6, PrizeConstants.FIRST_PRIZE),
    SECOND(5, PrizeConstants.SECOND_PRIZE),
    THIRD(5, PrizeConstants.THIRD_PRIZE),
    FOURTH(4, PrizeConstants.FOURTH_PRIZE),
    FIFTH(3, PrizeConstants.FIFTH_PRIZE),
    NONE(0, 0);

    private final int matchCount;
    private final long prize;

    Rank(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && matchBonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
