package lotto.domain;

public enum Rank {
    THREE(3, 5000, false),
    FOUR(4, 50000, false),
    FIVE(5, 1500000, false),
    FIVE_AND_BONUS(5, 30000000, true),
    SIX(6, 2000000000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final long prize;
    private boolean matchBonus;

    Rank(int matchCount, long prize, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }
}
