package lotto.domain;

import java.util.List;

public enum WinningRank {

    FIRST_RANK(6, false, 2_000_000_000),
    SECOND_RANK(5, true, 30_000_000),
    THIRD_RANK(5, false, 1_500_000),
    FOURTH_RANK(4, false, 50_000),
    FIFTH_RANK(3, false, 5_000),
    NOTHING(0, false, 0),
    ;

    private static final List<WinningRank> ORDER_BY_RANK =
            List.of(FIRST_RANK, SECOND_RANK, THIRD_RANK, FOURTH_RANK, FIFTH_RANK, NOTHING);

    private final int matchCountLimit;
    private final boolean isNeedBonusMatch;
    private final long winningAmount;

    WinningRank(int matchCountLimit, boolean isNeedBonusMatch, long winningAmount) {
        this.matchCountLimit = matchCountLimit;
        this.isNeedBonusMatch = isNeedBonusMatch;
        this.winningAmount = winningAmount;
    }

    public static WinningRank findRank(int matchCount, boolean isBonusMatch) {
        return ORDER_BY_RANK.stream()
                .filter(rank -> rank.isSatisfyRankCondition(matchCount, isBonusMatch))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(""));
    }

    private boolean isSatisfyRankCondition(int matchCount, boolean isBonusMatch) {
        return isSatisfyMatchCount(matchCount) && isSatisfyBonusMatch(isBonusMatch);
    }

    private boolean isSatisfyMatchCount(int matchCount) {
        return matchCount >= matchCountLimit;
    }

    private boolean isSatisfyBonusMatch(boolean isBonusMatch) {
        return isBonusMatch || !isNeedBonusMatch;
    }

    public long getWinningAmount() {
        return winningAmount;
    }
}
