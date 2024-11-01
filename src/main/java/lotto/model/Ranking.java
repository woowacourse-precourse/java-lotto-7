package lotto.model;


public enum Ranking {
    FIRST(6, false, 2_000_000_000)
    , SECOND(5, true, 30_000_000) //보너스 볼 포함
    , THIRD(5, false, 1_500_000) // 보너스 볼 포함x
    , FOURTH(4, false, 50_000)
    , FIFTH(3, false, 5_000)
    , NONE(0, false, 0);

    private final int matchCount;
    private final boolean isMatchBonus;
    private final int prize;

    Ranking(int matchCount, boolean isMatchBonus, int prize) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
        this.prize = prize;
    }

    public static Ranking valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

//    public int getMatchCount() {
//        return this.matchCount;
//    }

    public int getPrize() {
        return this.prize;
    }
}
