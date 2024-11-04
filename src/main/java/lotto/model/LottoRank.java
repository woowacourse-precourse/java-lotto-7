package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.db.Lotto;

public class LottoRank {

    private static final Map<Integer, Integer> MATCH_CNT_TO_RANK = new HashMap<>();
    private static final int NONE_RANK = -1;

    private final int[] rankCnts;

    static {
        MATCH_CNT_TO_RANK.put(6, 1);
        MATCH_CNT_TO_RANK.put(5, 3);
        MATCH_CNT_TO_RANK.put(4, 4);
        MATCH_CNT_TO_RANK.put(3, 5);
    }

    public LottoRank(List<Lotto> buyerLotties, Lotto winningLotto, int bonus) {
        this.rankCnts = new int[6];
        buyerLotties.stream()
                .map(lotto -> parseRank(lotto, winningLotto, bonus))
                .filter(rank -> rank != NONE_RANK)
                .forEach(rank -> rankCnts[rank]++);
    }

    private int parseRank(Lotto buyerLotto, Lotto winningLotto, int bonus) {
        int rank = MATCH_CNT_TO_RANK.getOrDefault(buyerLotto.getMatchCnt(winningLotto), NONE_RANK);
        if (isSecondLottoRank(buyerLotto, bonus, rank)) {
            return 2;
        }
        return rank;
    }

    private static boolean isSecondLottoRank(Lotto lotto, int bonus, int rank) {
        return rank == 3 && lotto.contains(bonus);
    }

    public int getCnt(int rank) {
        return rankCnts[rank];
    }

    public int size() {
        return rankCnts.length;
    }
}
