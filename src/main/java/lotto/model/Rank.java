package lotto.model;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "1등"),
    SECOND(5, true, 30_000_000, "2등"),
    THIRD(5, false, 1_500_000, "3등"),
    FOURTH(4, false, 50_000, "4등"),
    FIFTH(3, false, 5_000, "5등"),
    NONE(0, false, 0, "낙첨");

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;
    private final String rank;

    Rank(int matchCount, boolean matchBonus, int prize, String rank) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.rank = rank;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public String getRank() {
        return rank;
    }
}
