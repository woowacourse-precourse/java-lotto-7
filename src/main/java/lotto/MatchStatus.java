package lotto;

public enum MatchStatus {
    NOTHING(0),
    MATCH_3(5_000),
    MATCH_4(50_000),
    MATCH_5(1_500_000),
    MATCH_5_WITH_BONUS(30_000_000),
    MATCH_6(2_000_000_000);

    private Integer revenue;

    MatchStatus(Integer revenue) {
        this.revenue = revenue;
    }

    public static MatchStatus getMatch (int matchCount, boolean bonus) {
        if (matchCount == 3) return MATCH_3;
        if (matchCount == 4) return MATCH_4;
        if (matchCount == 5 && bonus) return MATCH_5_WITH_BONUS;
        if (matchCount == 5) return MATCH_5;
        if (matchCount == 6) return MATCH_6;
        return NOTHING;
    }

    public static int getRevenue(MatchStatus status) {
        return status.revenue;
    }
}
