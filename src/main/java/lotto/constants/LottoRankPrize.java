package lotto.constants;

import java.util.HashMap;
import java.util.Map;

public enum LottoRankPrize {
    FIRST(1,200000000,6),
    SECOND(2, 30000000,5)
    , THIRD(3, 1500000,5)
    , FOURTH(4, 50000,4)
    , FIFTH(5, 5000,3);
    private final int rank;
    private final int prize;
    private final int matchCount;

    private static final Map<Integer, LottoRankPrize> rankMap = new HashMap<>();

    static {
        for (LottoRankPrize rankPrize : LottoRankPrize.values()) {
            rankMap.put(rankPrize.getRank(), rankPrize);
        }
    }

    LottoRankPrize(int rank, int prize, int matchCount) {
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

    public static LottoRankPrize getByRank(int rank) {
        return rankMap.get(rank); // rank에 해당하는 LottoRankPrize 반환
    }
}

