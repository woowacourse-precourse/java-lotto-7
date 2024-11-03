package lotto.dto;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningLotto;

public record LottoStatistics(
    Map<RankDTO, Integer> statistics,
    double profit
) {
    public static LottoStatistics from(WinningLotto winningLotto, Lottos lottos) {
        Map<RankDTO, Integer> statistics = new TreeMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> statistics.put(RankDTO.from(rank), 0));
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = winningLotto.calculateRank(lotto);
            RankDTO dto = RankDTO.from(rank);
            statistics.put(dto, statistics.get(dto) + 1);
        }
        return new LottoStatistics(
                statistics,
                Math.round(lottos.calculateProfit(winningLotto) * 10000) / 100.0
        );
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
