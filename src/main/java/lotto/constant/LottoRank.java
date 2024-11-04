package lotto.constant;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean hasBonusMatch;
    private final int prizeAmount;

    LottoRank(int matchCount, boolean hasBonusMatch, int prizeAmount) {
        this.matchCount = matchCount;
        this.hasBonusMatch = hasBonusMatch;
        this.prizeAmount = prizeAmount;
    }

    public static LottoRank valueOf(int matchCount, boolean hasBonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matches(matchCount, hasBonusMatch))
                .findFirst()
                .orElse(MISS);
    }

    private boolean matches(int matchCount, boolean hasBonusMatch) {
        return this.matchCount == matchCount && this.hasBonusMatch == hasBonusMatch;
    }

    public static boolean isWinning(LottoRank lottoRank) {
        return lottoRank != LottoRank.MISS;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonusMatch() {
        return hasBonusMatch;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
