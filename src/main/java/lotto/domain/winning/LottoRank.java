package lotto.domain.winning;

import java.util.Arrays;

public enum LottoRank {

    PRIZE_FIRST(1, 6, 2_000_000_000),
    PRIZE_SECOND(2, 5, 30_000_000),
    PRIZE_THIRD(3, 5, 1_500_000),
    PRIZE_FOURTH(4, 4, 50_000),
    PRIZE_FIFTH(5, 3, 5_000),
    NONE(6, 0, 0);

    private final int rank;
    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int rank, int matchCount, int prizeMoney) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank of(int matchCount, boolean bonusNumberMatch) {
        if (matchCount == 5) {
            return getRankForFiveMatch(bonusNumberMatch);
        }
        return findRankByMatchCount(matchCount);
    }

    private static LottoRank getRankForFiveMatch(boolean bonusNumberMatch) {
        if (bonusNumberMatch) {
            return PRIZE_SECOND;
        }
        return PRIZE_THIRD;
    }

    private static LottoRank findRankByMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(matchCount))
                .findFirst()
                .orElse(NONE);
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

    public int getRank() {
        return rank;
    }

    public boolean isWinning() {
        return this != NONE;
    }

}
