package lotto.model;

public class LottoResult {
    private final int matchingCount;
    private final boolean matchingBonus;

    public LottoResult(int matchingCount, boolean matchingBonus) {
        this.matchingCount = matchingCount;
        this.matchingBonus = matchingBonus;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isMatchingBonus() {
        return matchingBonus;
    }
}
