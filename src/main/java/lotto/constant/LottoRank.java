package lotto.constant;

public enum LottoRank {
    FIRST("0", 6, false, 2000000000, "6개 일치 (2,000,000,000원) - ", true),
    SECOND("1", 5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", true),
    THIRD("2", 5, false, 1500000, "5개 일치 (1,500,000원) - ", true),
    FOURTH("3", 4, false, 50000,"4개 일치 (50,000원) - ", true),
    FIFTH("4", 3, false, 5000, "3개 일치 (5,000원) - ", true),
    NONE("5", 0, false, 0, "", false);

    private final String rank;
    private final int matchCount;
    private final boolean requiresBonus;
    private final int prizeMoney;
    private final String script;
    private final boolean isPrint;

    LottoRank(String rank, int matchCount, boolean requiresBonus, int prizeMoney, String script, boolean isPrint) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prizeMoney = prizeMoney;
        this.script = script;
        this.isPrint = isPrint;
    }

    public String getRank() {
        return rank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getScript() {
        return script;
    }

    public boolean isPrint() {
        return isPrint;
    }

    public static LottoRank findRank(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank.requiresBonus == bonusMatch) {
                return rank;
            }
        }
        return NONE;
    }
}