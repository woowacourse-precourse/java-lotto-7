package lotto.model;

import static lotto.constants.RankConstants.*;

public enum Rank {
    FIRST(FIRST_MATCH_COUNT, FIRST_PRIZE_AMOUNT),
    SECOND(SECOND_MATCH_COUNT, SECOND_PRIZE_AMOUNT),
    THIRD(THIRD_MATCH_COUNT, THIRD_PRIZE_AMOUNT),
    FOURTH(FOURTH_MATCH_COUNT, FOURTH_PRIZE_AMOUNT),
    FIFTH(FIFTH_MATCH_COUNT, FIFTH_PRIZE_AMOUNT),
    NONE(NONE_MATCH_COUNT, NONE_PRIZE_AMOUNT);

    private final int matchingCount;
    private final int prize;

    Rank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int calculateTotalPrize(int count) {
        return prize * count;
    }

    public static Rank determineRank(int matchingCount, boolean hasBonus) {
        if (matchingCount == FIRST.matchingCount) return FIRST;
        if (matchingCount == SECOND.matchingCount && hasBonus) return SECOND;
        if (matchingCount == THIRD.matchingCount) return THIRD;
        if (matchingCount == FOURTH.matchingCount) return FOURTH;
        if (matchingCount == FIFTH.matchingCount) return FIFTH;
        return NONE;
    }
}