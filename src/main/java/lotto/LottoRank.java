package lotto;

public enum LottoRank {
    First(6, false, 2000000000),
    Second(5, true, 30000000),
    Third(5, false, 1500000),
    Fourth(4, false, 50000),
    Fifth(3, false, 5000),
    None(0,false,0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getPrize() {
        return prize;
    }

    LottoRank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static LottoRank valueOf(int countOfMatch, boolean isMatchBonus) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == countOfMatch && rank.matchBonus == isMatchBonus) {
                return rank;
            }
        }
        return None;
    }
}
