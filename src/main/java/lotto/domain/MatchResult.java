package lotto.domain;

public class MatchResult {
    private final long matchCount;
    private final boolean matchBonus;

    public MatchResult(long matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
