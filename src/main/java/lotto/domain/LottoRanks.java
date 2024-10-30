package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoRanks {

    private final Map<LottoRank, Integer> ranks = new EnumMap<>(LottoRank.class);

    public void add(LottoRank rank) {
        ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
    }

    public Map<LottoRank, Integer> getRanks() {
        return Map.copyOf(ranks);
    }

}
