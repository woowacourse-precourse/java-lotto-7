package lotto.dto;

public class WinningResult {
    private final int matchCount;
    private final int bonusMatchCount;

    public WinningResult(int matchCount, int bonusMatchCount) {
        this.matchCount = matchCount;
        this.bonusMatchCount = bonusMatchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getBonusMatchCount() {
        return bonusMatchCount;
    }
}
