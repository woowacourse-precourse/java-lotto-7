package lotto.model;

public enum PrizeTable {
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    FIVE_BONUS_MATCHES(5, 30_000_000),
    SIX_MATCHES(6, 2_000_000_000);

    private final int prizeMoney;
    private int count = 0;

    PrizeTable(int matchNumbers, int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public void addCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getTotalPrizeMoney() {
        return count * prizeMoney;
    }

    public void getRateOfReturn() {

    }
}
