package lotto.model;

public enum Rank {
    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return NONE;
    }

    public String getDescription() {
        if (this == SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원)", matchCount, formatPrize());
        }
        if (this.matchCount >= 3) {
            return String.format("%d개 일치 (%s원)", matchCount, formatPrize());
        }
        return null;
    }

    private String formatPrize() {
        return String.format("%,d", prize);
    }

    public int getPrize() {
        return prize;
    }
}
