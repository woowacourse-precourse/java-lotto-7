package lotto;

public enum LottoRank{
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int  match;
    private final boolean matchBonus;
    private final int prize;


    LottoRank(int match, boolean matchBonus, int prize) {
        this.match = match;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return match;
    }

    public static LottoRank valueOf(int match, boolean matchBonus) {
        for (LottoRank rank : values()) {
            if (rank.match == match && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return MISS;
    }

}
