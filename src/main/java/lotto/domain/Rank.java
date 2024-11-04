package lotto.domain;

public enum Rank {
    MISS(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private static final String FORMAT_MATCH_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s원)";
    private static final String FORMAT_MATCH = "%d개 일치 (%s원)";
    private static final String PRIZE_FORMAT = "%,d";

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static Rank calculate(long matchCount, boolean hasBonusNumber) {
        if (matchCount == SECOND.matchCount) {
            return getRankBonusNumber(hasBonusNumber);
        }
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return MISS;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        if (this == SECOND) {
            return String.format(FORMAT_MATCH_WITH_BONUS, matchCount, formatPrize());
        }
        return String.format(FORMAT_MATCH, matchCount, formatPrize());
    }

    private String formatPrize() {
        return String.format(PRIZE_FORMAT, prize);
    }

    private static Rank getRankBonusNumber(boolean hasBonusNumber) {
        if (hasBonusNumber) {
            return SECOND;
        }
        return THIRD;
    }
}
