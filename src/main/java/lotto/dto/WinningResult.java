package lotto.dto;

public class WinningResult {
    private final int matchCount;
    private final boolean isMatchedBonusNumber;

    public WinningResult(int matchCount, boolean isMatchedBonusNumber) {
        this.matchCount = matchCount;
        this.isMatchedBonusNumber = isMatchedBonusNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchedBonusNumber() {
        return isMatchedBonusNumber;
    }
}
