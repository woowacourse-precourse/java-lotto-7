package lotto;

public enum MatchType {
    THREE_MATCHES(5_000),
    FOUR_MATCHES(50_000),
    FIVE_MATCHES(1_500_000),
    FIVE_BONUS(30_000_000),
    SIX_MATCHES(2_000_000_000);


    private final int prise;

    MatchType(int prise) {
        this.prise = prise;
    }

    public int getPrise() {
        return prise;
    }
}
