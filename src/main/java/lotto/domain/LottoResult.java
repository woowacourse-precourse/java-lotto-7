package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
    private final int purchaseAmount;

    public LottoResult(List<Lotto> lottos, WinningChecker winningChecker, int purchaseAmount){
        this.purchaseAmount = purchaseAmount;
        for(Lotto lotto : lottos){
            Rank rank = winningChecker.checkLotto(lotto);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
    }

    public int getCount(Rank rank){
        return rankCounts.getOrDefault(rank,0);
    }

    public int calculateTotalPrize(){
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public double calculateYield(){
        int totalPrize = calculateTotalPrize();
        double yield = (double) totalPrize / purchaseAmount * 100;
        return Math.round(yield * 10) / 10.0;
    }
}