package lotto.model;

public enum LottoMatchEnum {
    MATCH_3(3, false, 5_000, "3개 일치 (5,000원)"),
    MATCH_4(4, false, 50_000, "4개 일치 (50,000원)"),
    MATCH_5(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    MATCH_5_WITH_BONUS(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MATCH_6(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prize;
    private final String displayName;

    LottoMatchEnum(int matchCount, boolean requiresBonus, int prize, String displayName) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
        this.displayName = displayName;
    }

    public int getPrize() {
        return prize;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static LottoMatchEnum getCategory(int matchCount, boolean bonusMatch) {
        for (LottoMatchEnum match : values()) {
            if (match.matchCount == matchCount && match.requiresBonus == bonusMatch) {
                return match;
            }
        }
        return null;
    }
}
