package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoRank {

    NONE(0, false, BigDecimal.ZERO),
    FIFTH(3, false, BigDecimal.valueOf(5_000)),
    FOURTH(4, false, BigDecimal.valueOf(50_000)),
    THIRD(5, false, BigDecimal.valueOf(1_500_000)),
    SECOND(5, true, BigDecimal.valueOf(30_000_000)),
    FIRST(6, false, BigDecimal.valueOf(2_000_000_000));

    private final int winningCount;
    private final boolean isBonusMatched;
    private final BigDecimal prize;

    LottoRank(int winningCount, boolean isBonusMatched, BigDecimal prize) {
        this.winningCount = winningCount;
        this.isBonusMatched = isBonusMatched;
        this.prize = prize;
    }

    public static LottoRank findRankByMatches(int matchCount, boolean isBonusMatched) {
        if (matchCount == 5) {
            return findRankWithBonusCheck(isBonusMatched);
        }
        return findRankWithoutBonusCheck(matchCount);
    }

    private static LottoRank findRankWithBonusCheck(boolean isBonusMatched) {
        if (isBonusMatched) {
            return SECOND;
        }
        return THIRD;
    }

    private static LottoRank findRankWithoutBonusCheck(int matchCount) {
        return Arrays.stream(values())
                     .filter(lottoRank -> lottoRank.winningCount == matchCount)
                     .findFirst()
                     .orElse(NONE);
    }

    public BigDecimal calculatePrizeByRankCount(int rankCount) {
        return prize.multiply(BigDecimal.valueOf(rankCount));
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }

    public BigDecimal getPrize() {
        return prize;
    }
}
