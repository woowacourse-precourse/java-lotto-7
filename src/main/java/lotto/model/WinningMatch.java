package lotto.model;

public enum WinningMatch {
    FIRST(2_000_000_000, 6, "6개 일치"),
    SECOND(30_000_000, 6, "5개 일치, 보너스 볼 일치"),
    THIRD(1_500_000, 5, "5개 일치"),
    FOURTH(50_000, 4, "4개 일치"),
    FIFTH(5_000, 3, "3개 일치");

    private final int priceAmount;
    private final int match;
    private final String matchAmount;

    WinningMatch(int priceAmount, int match, String matchAmount) {
        this.priceAmount = priceAmount;
        this.match = match;
        this.matchAmount = matchAmount;
    }

    public int getPriceAmount() {
        return priceAmount;
    }

    public int getMatch() {
        return match;
    }

    public String getMatchAmount() {
        return matchAmount;
    }
}
