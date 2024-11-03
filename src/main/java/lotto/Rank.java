package lotto;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NONE(0, false, 0, "");

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;
    private final String matchCountText;

    Rank(int matchCount, boolean matchBonus, int prizeMoney, String matchCountText) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
        this.matchCountText = matchCountText;
    }

    public static Rank getRank(int matchCount, boolean bonusMatch) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                if (rank == SECOND && bonusMatch) {
                    return rank;
                }
                if (rank != SECOND) {
                    return rank;
                }
            }
        }
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        if (matchCount >= 3) {
            return values()[8 - matchCount];
        }
        return NONE;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMatchCount() {
        return matchCountText;
    }

    public String getPrize() {
        return String.format("%,d", prizeMoney);
    }
}
