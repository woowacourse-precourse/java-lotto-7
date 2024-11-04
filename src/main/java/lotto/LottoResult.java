package lotto;

public class LottoResult {
    private final int matchingCount;
    private final boolean matchBonus;

    public LottoResult(int matchingCount, boolean matchBonus) {
        this.matchingCount = matchingCount;
        this.matchBonus = matchBonus;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
