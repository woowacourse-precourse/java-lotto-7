package lotto.lotto;

public enum LottoWinning {

    THREE_MATCH(3, 5000, 0),
    FOUR_MATCH(4, 50000, 0),
    FIVE_MATCH(5, 1500000, 0),
    FIVE_MATCH_WITH_BONUS_NUMBER(5, 30000000, 0),
    SIX_MATCH(6, 2000000000, 0);

    private final int matchedCount;
    private final int price;
    private int count;

    LottoWinning(int matchedCount, int price, int count) {
        this.matchedCount = matchedCount;
        this.price = price;
        this.count = 0;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }

    public void reset() {
        count = 0;
    }
}