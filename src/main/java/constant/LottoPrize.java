package constant;

public enum LottoPrize {
    THREE_MATCH(5_000),
    FOUR_MATCH(50_000),
    FIVE_MATCH(1_500_000),
    FIVE_BONUS_MATCH(30_000_000),
    SIX_MATCH(2_000_000_000);

    private final int prize;

    LottoPrize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

}
