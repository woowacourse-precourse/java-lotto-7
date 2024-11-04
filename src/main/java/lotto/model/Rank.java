package lotto.model;

import java.util.function.BiFunction;

public enum Rank {
    FIFTH(3, false, 5_000, (matchCount, isBonusMatch) -> matchCount == 3),
    FOURTH(4, false, 50_000, (matchCount, isBonusMatch) -> matchCount == 4),
    THIRD(5, false, 1_500_000, (matchCount, isBonusMatch) -> matchCount == 5 && !isBonusMatch),
    SECOND(5, true, 30_000_000, (matchCount, isBonusMatch) -> matchCount == 5 && isBonusMatch),
    FIRST(6, false, 2_000_000_000, (matchCount, isBonusMatch) -> matchCount == 6);

    private final int matchCount;
    private final boolean isBonusMatch;
    private final long prize;
    private final BiFunction<Integer, Boolean, Boolean> checkRank;

    Rank(int matchCount, boolean isBonusMatch, long prize, BiFunction<Integer, Boolean, Boolean> checkRank) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.prize = prize;
        this.checkRank = checkRank;
    }

    public boolean checkRank(int matchCount, boolean isBonusMatch) {
        return checkRank.apply(matchCount, isBonusMatch);
    }

    public long getPrize() {
        return prize;
    }
}
