package lotto.domain;

public enum Rank {

    NONE(0,false,0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private static final String MATCH_WITH_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String MATCH_FORMAT = "%d개 일치 (%s원) - %d개";

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;
    private int count = 0;

    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }

    public static Rank getRank(int matchCount, boolean matchBonus) {
        for (Rank rank : values()) {
            if (rank.isMatchingRank(matchCount, matchBonus)) {
                return rank;
            }
        }
        return NONE;
    }

    private boolean isMatchingRank(int matchCount, boolean matchBonus) {
        return this.matchCount == matchCount && this.matchBonus == matchBonus;
    }

    @Override
    public String toString() {
        if (matchBonus) {
            return String.format(MATCH_WITH_BONUS_FORMAT, matchCount, formatPrize(), count);
        }
        return String.format(MATCH_FORMAT, matchCount, formatPrize(), count);
    }

    private String formatPrize() {
        return String.format("%,d", prize);
    }
}
