package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000),
    NONE(0, false, 0),
    ;

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prize;

    Rank(int matchCount, boolean requiresBonus, int prize) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
    }

    public static Rank determineRank(int matchCount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(rank -> isRankMatching(rank, matchCount, hasBonus))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isRankMatching(Rank rank, int matchCount, boolean hasBonus) {
        return rank.matchCount == matchCount && (!rank.requiresBonus || hasBonus);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isRequiresBonus() {
        return requiresBonus;
    }
}
