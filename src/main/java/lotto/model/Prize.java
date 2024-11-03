package lotto.model;

public enum Prize {
    FIFTH(3, false, 5000,"3개 일치 (5,000원)"),
    FOURTH(4, false, 50000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final boolean hasBonus;
    private final int prizeMoney;
    private final String description; // 출력용 설명 추가
    private int count;

    Prize(int matchCount, boolean hasBonus, int prizeMoney, String description) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prizeMoney = prizeMoney;
        this.description = description;
        this.count = 0;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count++;
    }

    public static Prize getPrize(int matchCount, boolean bonusMatch) {
        for (Prize prize : values()) {
            if (prize.matchCount == matchCount && prize.hasBonus == bonusMatch) {
                return prize;
            }
        }
        return null;
    }
}
