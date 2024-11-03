package lotto.model;

public enum PrizeSheet {

    FIRST(3, false, 5000),
    SECOND(4, false, 50000),
    THIRD(5, false, 1500000),
    FOURTH(5, true, 30000000),
    FIFTH(6, false, 2000000000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    PrizeSheet(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getPrize() {
        return prize;
    }
}
