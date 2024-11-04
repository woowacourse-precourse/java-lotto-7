package lotto.model.constant;

public enum Match {
    THREE(3, "5,000원", 5_000),
    FOUR(4, "50,000원", 50_000),
    FIVE(5, "1,500,000원", 1_500_000),
    BONUS(5, "30,000,000원", 30_000_000),
    SIX(6, "2,000,000,000원", 2_000_000_000);

    private final int count;
    private final String prizeLabel;
    private final int prize;

    Match(final int count, final String prizeLabel, final int prize) {
        this.count = count;
        this.prizeLabel = prizeLabel;
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }

    public String getPrizeLabel() {
        return prizeLabel;
    }

    public int getPrize() {
        return prize;
    }
}