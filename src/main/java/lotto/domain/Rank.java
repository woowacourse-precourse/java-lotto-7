package lotto.domain;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public String getPrizeToString(){
        return String.format("%,d", prize);
    }

    public static Rank getRank(int count, boolean bonus) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == count && rank.matchBonus == bonus) {
                return rank;
            }
        }
        return NONE;
    }
}

