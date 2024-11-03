package lotto.component;

public class LottoMatchCounts {
    private final int correctNumberCount;
    private final boolean isBonusMatched;
    public LottoMatchCounts(int matchCount, boolean matchBonus) {
        this.correctNumberCount = matchCount;
        this.isBonusMatched = matchBonus;
    }

    public int getCorrectNumberCount() {
        return correctNumberCount;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }

}
