package lotto.domain;

public enum LottoRank {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000), // 5개 일치 + 보너스
    SIX(6, 2000000000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;
    private int count = 0;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }


    public void incrementCount() {
        this.count++;
    }


    public int getCount() {
        return count;
    }


    public int getPrize() {
        return prize;
    }


    public static LottoRank valueOfMatch(int matchCount, boolean matchBonus) {
        if (matchCount == 6) return SIX;
        if (matchCount == 5 && matchBonus) return FIVE_BONUS;
        if (matchCount == 5) return FIVE;
        if (matchCount == 4) return FOUR;
        if (matchCount == 3) return THREE;
        return NONE;
    }
}
