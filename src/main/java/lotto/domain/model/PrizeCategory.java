package lotto.domain.model;

public enum PrizeCategory {
    FIRST(6, false, 2_000_000_000), SECOND(5, true, 30_000_000), THIRD(5, false, 1_500_000), FOURTH(4, false,
            50_000), FIFTH(3, false, 5_000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    PrizeCategory(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static PrizeCategory getCategory(int matchCount, boolean matchBonus) {
        for (PrizeCategory category : values()) {
            if (category.matchCount == matchCount && category.matchBonus == matchBonus) {
                return category;
            }
        }
        return null;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}