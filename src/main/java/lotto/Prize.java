package lotto;

public enum Prize {
    FIFTH(5, "3개 일치", 5_000, false),
    FOURTH(4, "4개 일치", 50_000, false),
    THIRD(3, "5개 일치", 1_500_000, false),
    SECOND(2, "5개 일치, 보너스 볼 일치", 30_000_000, true),
    FIRST(1, "6개 일치", 2_000_000_000, false);

    private final int rank;
    private final String rankName;
    private final int prizeAmount;
    private final boolean requiresBonus;

    Prize(int rank, String rankName, int prizeAmount, boolean requiresBonus) {
        this.rank = rank;
        this.rankName = rankName;
        this.prizeAmount = prizeAmount;
        this.requiresBonus = requiresBonus;
    }

    public int getRank() {
        return rank;
    }

    public String getRankName() {
        return rankName;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean requiresBonus() {
        return requiresBonus;
    }
}
