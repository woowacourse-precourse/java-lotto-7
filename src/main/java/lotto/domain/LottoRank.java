package lotto.domain;

public enum LottoRank {
    FIFTH(3, "5,000", 5000),
    FOURTH(4, "50,000", 50000),
    THIRD(5, "1,500,000", 1500000),
    SECOND(5, "30,000,000", 30000000),
    FIRST(6, "2,000,000,000", 2000000000);

    private final int matchCount;
    private final String formattedPrize;
    private final int prize;

    LottoRank(int matchCount, String formattedPrize, int prize) {
        this.matchCount = matchCount;
        this.formattedPrize = formattedPrize;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getFormattedPrize() {
        return formattedPrize;
    }

    public int getPrize() {
        return prize;
    }
}
