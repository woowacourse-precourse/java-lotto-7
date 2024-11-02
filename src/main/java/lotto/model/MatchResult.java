package lotto.model;

public class MatchResult {
    private int matchCount;
    private boolean matchBonus;
    public MatchResult(int matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

}
