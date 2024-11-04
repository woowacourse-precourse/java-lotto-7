package lotto.model;

public enum NumberMatchType {
    MATCH_3(3, 5000, "3개 일치 (5,000원) - "),
    MATCH_4(4, 50000, "4개 일치 (50,000원) - "),
    MATCH_5(5, 1500000, "5개 일치 (1,500,000원) - "),
    MATCH_5_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MATCH_6(6, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int matchCount;
    private final int price;
    private final String message;

    NumberMatchType(int matchCount, int price, String message) {
        this.matchCount = matchCount;
        this.price = price;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getMessage() {
        return message;
    }

    public int getPrice() {
        return price;
    }

    public NumberMatchType matchBonus(boolean isBonusMatched) {
        if (this == MATCH_5 && isBonusMatched) {
            return NumberMatchType.MATCH_5_BONUS;
        }
        return this;
    }
}