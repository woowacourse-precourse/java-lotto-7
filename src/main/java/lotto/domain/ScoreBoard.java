package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.domain.constant.LottoRank;

public class ScoreBoard {
    private final List<Lotto> lottos;
    private final Winning winning;
    private final Map<LottoRank, Integer> rankCounts;

    public ScoreBoard(List<Lotto> lottos, Winning winning) {
        this.lottos = lottos;
        this.winning = winning;
        this.rankCounts = initRankCounts();
    }

    public Map<LottoRank, Integer> calculateRanks() {

        Map<LottoRank, Integer> calculatedRanks = lottos.stream()
                .map(lotto -> lotto.getRank(winning))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.summingInt(rank -> 1)));

        rankCounts.putAll(calculatedRanks);
        return rankCounts;

    }

    private Map<LottoRank, Integer> initRankCounts() {
        Map<LottoRank, Integer> rankCounts = new HashMap<>();

        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }

        return rankCounts;
    }

}
