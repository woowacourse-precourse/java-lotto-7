package lotto;

public enum Prize {
    FIRST("1등", 6, 2_000_000_000),
    SECOND("2등", 5, 30_000_000, true),
    THIRD("3등", 5, 1_500_000, false),
    FOURTH("4등", 4, 50_000),
    FIFTH("5등", 3, 5_000);

    private final String explain;
    private final int matchedCount;
    private final int prizeMoney;
    private final boolean bonus;

    Prize(String explain, int matchedCount, int prizeMoney, boolean bonus) {
        this.explain = explain;
        this.matchedCount = matchedCount;
        this.prizeMoney = prizeMoney;
        this.bonus = bonus;
    }

    Prize(String explain, int matchedCount, int prizeMoney) {
        this(explain, matchedCount, prizeMoney, false);
    }

    public String getExplain() {
        return explain;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        String string = explain + ": " +
                matchedCount + "개 번호 ";

        if (this.bonus) {
            string += "+ 보너스 번호 ";
        }

        string += "일치 / " +
                String.format("%,d", prizeMoney) +
                "원";
        return string;
    }
}
