package lotto;

public enum Rank {
    NONE(0, ""),
    FIFTH(5_000, "3개 일치 (5,000원)"),
    FOURTH(50_000, "4개 일치 (50,000원)"),
    THIRD(1_500_000, "5개 일치 (1,500,000원)"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final long price;
    private final String description;

    Rank(long price, String description) {
        this.price = price;
        this.description = description;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5) {
            return getRankForFiveMatches(matchBonus);
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    private static Rank getRankForFiveMatches(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }

    public long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
