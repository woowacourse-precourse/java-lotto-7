package lotto.core.constants;

public enum WinningStatistics {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000),
    ;

    private final int matchCount;
    private final boolean matchBonus;
    private final int winnings;


    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean getMatchBonus() {
        return this.matchBonus;
    }

    public long getWinningPrize(long count) {
        // 상금 = 등수에 따른 금액 * 당첨된 장 수
        return count * this.winnings;
    }

    public int getWinnings() {
        return this.winnings;
    }

    WinningStatistics(int matchCount, boolean matchBonus, int winnings) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.winnings = winnings;
    }
}
