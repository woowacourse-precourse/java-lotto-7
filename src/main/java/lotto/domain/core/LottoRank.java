package lotto.domain.core;

public enum LottoRank {
    MATCH_THREE_NUMBER(5_000, 3, null),
    MATCH_FOUR_NUMBER(50_000, 4, null),
    MATCH_FIVE_NUMBER(1_500_000, 5, false),
    MATCH_FIVE_NUMBER_WITH_BONUS_NUMBER(30_000_000, 5, true),
    MATCH_SIX_NUMBER(2_000_000_000, 6, null);

    private final int price;
    private final int matchCount;
    private final Boolean hasBonus;

    LottoRank(int price, int matchCount, Boolean hasBonus) {
        this.price = price;
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
    }

    public int getPrice() {
        return price;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Boolean hasBonus() {
        return hasBonus;
    }

    public boolean checkMatchCount(int value) {
        return matchCount == value;
    }

    public boolean checkHasBonus(boolean value) {
        return hasBonus == null || hasBonus == value;
    }
}
