package lotto.model;

public enum Rank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean hasBonus;
    private final int prizeMoney;

    Rank(int matchCount, boolean hasBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prizeMoney = prizeMoney;
    }

    public int getPrize() {
        return prizeMoney;
    }

    public static Rank matchingRank(int matchCount, boolean hasBonus) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                if (rank.hasBonus == hasBonus) {
                    return rank;
                }
            }
        }

        return null;
    }

    public String displayRankResult(int count) {
        String formattedPrizeMoney = String.format("%,d", prizeMoney);

        if (this == SECOND) {
            return matchCount + "개 일치, 보너스 볼 일치 (" + formattedPrizeMoney + "원) - " + count + "개";
        }

        return matchCount + "개 일치 (" + formattedPrizeMoney + "원) - " + count + "개";
    }
}
