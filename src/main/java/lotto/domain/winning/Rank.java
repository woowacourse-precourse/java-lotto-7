package lotto.domain.winning;

import java.util.Arrays;

public enum Rank {

    LAST(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int prizeMoney;

    Rank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank of(int matchCount, boolean bonusNumberMatch) {
        if (matchCount == 5) {
            return getRankForFiveMatch(bonusNumberMatch);
        }
        return findRankByMatchCount(matchCount);
    }

    private static Rank getRankForFiveMatch(boolean bonusNumberMatch) {
        if (bonusNumberMatch) {
            return SECOND;
        }
        return THIRD;
    }

    private static Rank findRankByMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(matchCount))
                .findFirst()
                .orElse(LAST);
    }

    private boolean isMatch(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
