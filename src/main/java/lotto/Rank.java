package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50000, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5000, "3개 일치 (5,000원)");

    private final int matchCount;
    private final boolean isBonusNumberMatched;
    private final int prizeMoney;
    private final String winningMessage;

    Rank(int matchCount, boolean isBonusNumberMatched, int prizeMoney, String winningMessage) {
        this.matchCount = matchCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
        this.prizeMoney = prizeMoney;
        this.winningMessage = winningMessage;
    }

    public static Rank valueOf (int matchCount, boolean isBonusNumberMatched) {
        return Arrays.stream(values())
                .filter(rank -> matchCount == rank.matchCount)
                .filter(rank -> isBonusNumberMatched == rank.isBonusNumberMatched)
                .findFirst()
                .orElse(null);
    }

    public String getWinningMessage() {
        return winningMessage;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
