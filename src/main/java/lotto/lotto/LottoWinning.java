package lotto.lotto;

public enum LottoWinning {

    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_WITH_BONUS_NUMBER(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchedCount;
    private final int price;

    LottoWinning(int matchedCount, int price) {
        this.matchedCount = matchedCount;
        this.price = price;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }
}