package lotto;

public class WinningStatus {

    private final int matchedNumberCount;
    private final boolean isBonusNumberMatched;

    public WinningStatus(final int matchedNumberCount, final boolean isBonusNumberMatched) {
        this.matchedNumberCount = matchedNumberCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
    }
}
