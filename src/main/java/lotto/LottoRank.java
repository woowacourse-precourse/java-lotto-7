package lotto;

public enum LottoRank {
    FIRSTPLACE(6, false, 2000000000),
    SECONDPLACE(5, true, 30000000),
    THIRDPLACE(5, false, 1500000),
    FOURTHPLACE(4, false, 50000),
    FIFTHPLACE(3, false, 5000),
    MISSPLACE(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    LottoRank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

}
