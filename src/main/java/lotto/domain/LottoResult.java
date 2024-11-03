package lotto.domain;

import lotto.util.LottoRank;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank,Integer> rankCountMap = new EnumMap<>(LottoRank.class);
    
    public LottoResult() {
        for(LottoRank rank : LottoRank.values()) {
            rankCountMap.put(rank,0);
        }
    }

    public void addRank(LottoRank rank) {
        rankCountMap.put(rank,rankCountMap.get(rank)+1);
    }
    public int getRankCount(LottoRank rank) {
        return rankCountMap.get(rank);
    }

    public Long calculateLottoPrize() {
        long Prize = 0L;
        for(LottoRank rank : rankCountMap.keySet()) {
            int count = rankCountMap.getOrDefault(rank,0);
            Prize += (long) rank.getPrize() * count;
        }
        return Prize;
    }

}
