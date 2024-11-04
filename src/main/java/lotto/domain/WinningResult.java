package lotto.domain;

public enum WinningResult {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchNumberCount;
    private final boolean matchBonusNumber;
    private final int prize;


    WinningResult(int matchNumberCount, boolean matchBonusNumber, int prize) {
        this.matchNumberCount = matchNumberCount;
        this.matchBonusNumber = matchBonusNumber;
        this.prize = prize;
    }

    public int getMatchNumberCount() {
        return this.matchNumberCount;
    }

    public boolean isMatchBonusNumber() {
        return matchBonusNumber;
    }

    public int getPrize() {
        return prize;
    }

}
