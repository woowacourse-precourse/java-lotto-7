package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> rankCount = new EnumMap<LottoRank, Integer>(LottoRank.class);

    public void addRank(LottoRank rank){
        rankCount.merge(rank, 1, Integer::sum);
    }

    public long getTotalPrize(){
        return rankCount.entrySet().stream()
                .mapToLong(entry -> 1L * entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Map<LottoRank, Integer> getRankCount(){
        return rankCount;
    }
}
