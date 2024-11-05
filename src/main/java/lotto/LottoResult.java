package lotto;

public enum LottoResult {
    THREE_MATCH(5000, "3개 일치"),
    FOUR_MATCH(50000, "4개 일치"),
    FIVE_MATCH(1500000, "5개 일치"),
    FIVE_BONUS_MATCH(30000000, "5개 일치, 보너스 볼 일치"),
    SIX_MATCH(2000000000, "6개 일치");

    private final int prize;
    private final String message;

    LottoResult(int prize, String message) {
        this.prize = prize;
        this.message = message;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return String.format("%s (%,d원)", message, prize);
    }
}
