package lotto.dto;

import java.util.Map;
import java.util.TreeMap;
import lotto.model.LottoResult;
import lotto.model.Rank;

public record LottoStatisticsDTO(
        Map<RankDTO, Integer> statistics,
        double profit
) {
    public static LottoStatisticsDTO from(LottoResult lottoResult, int amount) {
        Map<RankDTO, Integer> statistics = new TreeMap<>();
        lottoResult.getResult().forEach((rank, value) -> putRank(
                statistics,
                rank,
                value
        ));
        return new LottoStatisticsDTO(
                statistics,
                lottoResult.computeProfit(amount)
        );
    }

    private static void putRank(Map<RankDTO, Integer> statistics, Rank rank, int value) {
        if (rank == Rank.LAST) {
            return;
        }
        statistics.put(RankDTO.from(rank), value);
    }

    public record RankDTO(
            int rank,
            long matchCount,
            long price,
            boolean containsBonus
    ) implements Comparable<RankDTO> {
        public static RankDTO from(Rank rank) {
            return new RankDTO(
                    rank.getRank(),
                    rank.getMatchCount(),
                    rank.getPrice(),
                    rank.isContainsBonus()
            );
        }

        @Override
        public int compareTo(RankDTO o) {
            return o.rank - this.rank;
        }
    }
}
