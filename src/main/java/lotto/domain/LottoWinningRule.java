package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoWinningRule {

    private static final HashMap<Integer, LottoRank> ranks = initRanks();
    private static final HashMap<LottoRank, LottoPrize> prizes = initPrizes();

    private static HashMap<Integer, LottoRank> initRanks() {
        return new HashMap<>(Map.of(LottoRank.FIRST.matches, LottoRank.FIRST,
                LottoRank.THIRD.matches, LottoRank.THIRD,
                LottoRank.FOURTH.matches, LottoRank.FOURTH,
                LottoRank.FIFTH.matches, LottoRank.FIFTH));
    }

    private static HashMap<LottoRank, LottoPrize> initPrizes() {
        return new HashMap<>(Map.of(LottoRank.FIRST, LottoPrize.FIRST,
                LottoRank.SECOND, LottoPrize.SECOND,
                LottoRank.THIRD, LottoPrize.THIRD,
                LottoRank.FOURTH, LottoPrize.FOURTH,
                LottoRank.FIFTH, LottoPrize.FIFTH,
                LottoRank.NONE, LottoPrize.NONE));
    }

    public static LottoRank getRank(Integer matches, boolean isMatchBonus) {
        LottoRank rank = ranks.getOrDefault(matches, LottoRank.NONE);
        if (rank == LottoRank.THIRD && isMatchBonus) {
            return LottoRank.SECOND;
        }
        return rank;
    }

    public static long getPrize(LottoRank rank) {
        return prizes.get(rank).value;
    }
}
