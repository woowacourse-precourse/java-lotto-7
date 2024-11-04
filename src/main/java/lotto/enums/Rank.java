package lotto.enums;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Rank(final int matchCount, final boolean matchBonus, final int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public String getDisplayText() {
        if (this == NONE) return "";
        final String bonusText = matchBonus ? ", 보너스 볼 일치" : "";
        return String.format("%d개 일치%s (%s원)", matchCount, bonusText, formatPrize(prize));
    }

    private static String formatPrize(final int prize) {
        return String.format("%,d", prize);
    }


    public static Rank getRank(final int matchCount, final boolean matchBonus) {
        for (final Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return NONE;
    }
}
