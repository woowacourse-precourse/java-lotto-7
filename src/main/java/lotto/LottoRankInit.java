package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoRankInit {

    public static Map<LottoRank, Integer> getLottoRank() {
        Map<LottoRank, Integer> winningStatistics = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            winningStatistics.put(rank, 0);
        }
        return winningStatistics;
    }

}
