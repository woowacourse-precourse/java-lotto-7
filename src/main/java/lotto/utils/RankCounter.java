package lotto.utils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.Rank;

public class RankCounter {

    private RankCounter() {
    }

    public static Map<Rank, Integer> countRanks(List<LottoTicket> lottoTickets) {
        Map<Rank, Integer> rankCounts = initializeRankCounts();

        for (LottoTicket lottoTicket : lottoTickets) {
            lottoTicket.countRank(rankCounts);
        }

        return rankCounts;
    }

    private static Map<Rank, Integer> initializeRankCounts() {
        Map<Rank, Integer> rankCounts = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.OUT_OF_RANK)) {
                continue;
            }
            rankCounts.put(rank, 0);
        }
        return rankCounts;
    }
}
