package lotto;

public enum LottoWinner {
    FIRST(2_000_000_000, 0),
    SECOND(30_000_000, 0),
    THIRD(1_500_000, 0),
    FOURTH(50_000, 0),
    FIFTH(5_000, 0);

    private final int prize;
    private int count;

    LottoWinner(int prize, int count) {
        this.prize = prize;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count++;
    }

    public long calculateProfit() {
        return (long) prize * count;
    }
}