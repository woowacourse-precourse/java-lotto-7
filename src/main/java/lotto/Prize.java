package lotto;

public enum Prize {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
    NONE(0, false, 0, "당첨되지 않음");

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;
    private final String description;

    Prize(int matchCount, boolean matchBonus, int prizeMoney, String description) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }

    public static Prize getPrize(int matchCount, boolean bonusMatch) {
        for (Prize prize : values()) {
            if (prize.matchCount == matchCount && prize.matchBonus == bonusMatch) {
                return prize;
            }
        }
        return NONE;
    }
}
