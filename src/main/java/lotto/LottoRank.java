package lotto;

public enum LottoRank {
    BLANK(0, 0, false),
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int match;
    private final int prize;
    private final boolean bonus;

    LottoRank(int match, int prize, boolean bonus) {
        this.match = match;
        this.prize = prize;
        this.bonus = bonus;
    }

    public int getMatch() {
        return match;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank win(final int match, final boolean bonus) {
        for (LottoRank rank : values()) {
            if (rank.getMatch() == match && rank.bonus == bonus) {
                return rank;
            }
        }
        return BLANK;
    }
}
