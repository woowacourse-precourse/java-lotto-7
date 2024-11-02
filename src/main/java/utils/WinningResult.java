package utils;

public enum WinningResult {
    FIRST(6, false, 0),
    SECOND(5, true, 1),
    THIRD(5, false, 2),
    FOURTH(4, false, 3),
    FIFTH(3, false, 4);

    private final int matchCount;
    private final boolean matchBonus;
    private final int resultIndex;

    WinningResult(int matchCount, boolean matchBonus, int resultIndex) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.resultIndex = resultIndex;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getResultIndex() {
        return resultIndex;
    }
}
