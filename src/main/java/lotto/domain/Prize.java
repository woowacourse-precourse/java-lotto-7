package lotto.domain;

public enum Prize {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NOTHING(0, false, 0);

    private int matchCount;
    private boolean matchBonusNumber;
    private int prizeMoney;

    Prize(int matchCount, boolean matchBonusNumber, int prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonusNumber = matchBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonusNumber() {
        return matchBonusNumber;
    }
}
