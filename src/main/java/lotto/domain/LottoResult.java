package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> rankCount;

    public LottoResult(){
        rankCount = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCount.put(rank, 0);
        }
    }

    public void addRank(LottoRank rank){
        rankCount.put(rank, rankCount.get(rank) + 1);
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
