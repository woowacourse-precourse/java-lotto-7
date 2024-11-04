package lotto.domain;

public enum WinningPrice {
    FIFTH_PLACE("3개 일치 (5,000원)", 5_000),
    FOURTH_PLACE("4개 일치 (50,000원)", 50_000),
    THIRD_PLACE("5개 일치 (1,500,000원)", 1_500_000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    FIRST_PLACE("6개 일치 (2,000,000,000원)", 2_000_000_000),
    LOSE("0개 일치", 0);

    private final String description;
    private final long price;

    WinningPrice(String description, long price) {
        this.description = description;
        this.price = price;
    }

    public static WinningPrice of(int matchCount, boolean bonusMatch) {
        if (matchCount == 3) {
            return FIFTH_PLACE;
        }
        if (matchCount == 4) {
            return FOURTH_PLACE;
        }
        if (matchCount == 5) {
            if (bonusMatch) {
                return SECOND_PLACE;
            }
            return THIRD_PLACE;
        }
        if (matchCount == 6) {
            return FIRST_PLACE;
        }
        return LOSE;
    }

    public String getDescription() {
        return description;
    }

    public long getPrice() {
        return price;
    }


}

