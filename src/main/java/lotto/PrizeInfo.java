package lotto;

public class PrizeInfo {

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    public PrizeInfo(int matchCount, boolean matchBonus, int prize) {
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
