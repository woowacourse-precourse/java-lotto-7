package lotto;

public class WinningStatus {

    private final int matchedNumberCount;
    private final boolean isBonusNumberMatched;

    public WinningStatus(final int matchedNumberCount, final boolean isBonusNumberMatched) {
        this.matchedNumberCount = matchedNumberCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
    }

    public WinningRank getWinningRank() {
        return WinningRank.from(this);
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public boolean isBonusNumberMatched() {
        return isBonusNumberMatched;
    }
}
