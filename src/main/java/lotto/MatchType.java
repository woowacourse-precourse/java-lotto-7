package lotto;

public enum MatchType {
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000),
    SIX_MATCHES(6, 2_000_000_000);

    private final int matchCount;
    private final int prise;

    MatchType(int matchCount, int prise) {
        this.matchCount = matchCount;
        this.prise = prise;
    }

    public int getPrise() {
        return prise;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
