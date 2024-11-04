package lotto.model;

public enum Prize {
    FIFTH(3, 5_000, " (5,000원)"),
    FOURTH(4, 50_000, " (50,000원)"),
    THIRD(5, 1_500_000, " (1,500,000원)"),
    SECOND(5, 30_000_000, ", 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2_000_000_000, " (2,000,000,000원)");


    private final int matchCount;
    private final int amount;
    private final String message;

    Prize(int matchCount, int amount, String message) {
        this.matchCount = matchCount;
        this.amount = amount;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }

    public String getMessage(){
        return message;
    }
}
