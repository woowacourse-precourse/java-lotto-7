package lotto.domain;

public class WinningResult {
    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    public WinningResult(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = calculatePrize(matchCount, bonusMatch);
    }

    private int calculatePrize(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return 2_000_000_000;
        if (matchCount == 5 && bonusMatch) return 30_000_000;
        if (matchCount == 5) return 1_500_000;
        if (matchCount == 4) return 50_000;
        if (matchCount == 3) return 5_000;
        return 0;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
