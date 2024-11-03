package lotto.handler.rank.process;

import java.util.HashMap;
import java.util.List;
import lotto.handler.purchase.process.Lotto;
import lotto.handler.purchase.process.WinningRank;

public class RankCounter {
    private final static int INITIAL_RANK_COUNT = 0;

    public HashMap<WinningRank, Integer> countRanks(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        HashMap<WinningRank, Integer> rankCounts = initailizeRankCounts();

        for (Lotto lotto : lottos) {
            WinningRank rank = lotto.getRank(winningNumbers, bonusNumber);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }

        return rankCounts;
    }

    private HashMap<WinningRank, Integer> initailizeRankCounts() {
        HashMap<WinningRank, Integer> rankCounts = new HashMap<>();
        for (WinningRank rank : WinningRank.values()) {
            rankCounts.put(rank, INITIAL_RANK_COUNT);
        }
        return rankCounts;
    }
}
