package lotto.domain;

public enum LottoRanking {
    THREE_MATCH(3, 5_000, false),
    FOUR_MATCH(4, 50_000, false),
    FIVE_MATCH(5, 1_500_000, false),
    FIVE_BONUS_MATCH(5, 30_000_000, true),
    SIX_MATCH(6, 2_000_000_000, false);

    private final int matchNumber;
    private final int price;
    private final boolean bonusMatch;

    LottoRanking(int matchNumber, int price, boolean bonusMatch) {
        this.matchNumber = matchNumber;
        this.price = price;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
