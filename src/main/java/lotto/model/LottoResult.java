package lotto.model;

public class LottoResult {
    private final long matchCount;
    private final boolean hasBonus;

    public LottoResult(long matchCount, boolean hasBonus) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public boolean getHasBonus() {
        return hasBonus;
    }
}
