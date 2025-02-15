package lotto;

public enum Rank {
    THREE_RANK("3개 일치 (5,000원) - ", 5000),
    FOUR_RANK("4개 일치 (50,000원) - ", 50000),
    FIVE_RANK("5개 일치 (1,500,000원) - ", 1500000),
    FIVE_BONUS_RANK("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    SIX_RANK("6개 일치 (2,000,000,000원) - ", 2000000000);

    private final String message;
    private final long price;

    Rank(String message, long price) {
        this.message = message;
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public long getPrice() {
        return price;
    }
}
