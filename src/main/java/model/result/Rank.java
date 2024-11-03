package model.result;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchingCount;
    private final boolean isBonusMatched;
    private final int prize;

    Rank(int matchingCount, boolean isBonusMatched, int prize) {
        this.matchingCount = matchingCount;
        this.isBonusMatched = isBonusMatched;
        this.prize = prize;
    }

    public static boolean hasCountToBeSecond(final int matchingCount) {
        return SECOND.matchingCount == matchingCount;
    }

    public static Rank findRank(int matchingCount, boolean isBonusMatched) {
        Rank rank = findMatchCount(matchingCount);

        if (rank == THIRD) {
            rank = checkSecond(isBonusMatched);
        }
        return rank;
    }

    private static Rank findMatchCount(int matchingCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchingCount == matchingCount)
                .findFirst()
                .orElse(NONE);
    }

    private static Rank checkSecond(boolean isBonusMatched) {
        if (isBonusMatched) {
            return SECOND;
        }
        return THIRD;
    }

    public static List<Rank> ranksExceptNone() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != NONE)
                .toList();
    }

    public static List<Rank> sortedRanksExceptNone() {
        return ranksExceptNone().stream()
                .sorted(Comparator.comparingInt(Rank::getMatchingCount))
                .toList();
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}
