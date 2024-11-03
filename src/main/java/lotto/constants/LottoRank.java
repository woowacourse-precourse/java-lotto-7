package lotto.constants;

import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
    FIRST(1,2000000000,6)
    , SECOND(2, 30000000,5)
    , THIRD(3, 1500000,5)
    , FOURTH(4, 50000,4)
    , FIFTH(5, 5000,3)
    , NO_LUCK(6,0,-1)
    ,;


    private final int rank;
    private final int prize;
    private final int matchCount;

    private static final Map<Integer, LottoRank> rankMap = new HashMap<>();

    static {
        for (LottoRank rankPrize : LottoRank.values()) {
            rankMap.put(rankPrize.getRank(), rankPrize);
        }
    }

    LottoRank(int rank, int prize, int matchCount) {
        this.rank = rank;
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static LottoRank getByRank(int rank) {
        return rankMap.get(rank);
    }

}

