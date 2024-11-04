package lotto.service;

import java.util.Map;
import lotto.domain.Rank;

public class WinningsCalculator {
    public int calculateTotalWinnings(Map<Rank,Integer> rankCount){
        int total = 0;
        for (Map.Entry<Rank, Integer> entry : rankCount.entrySet()){
            total += entry.getKey().getPrize() * entry.getValue();
        }
        return total;
    }

    public double calculateROI(long totalWinnings, int purchaseAmount){
        return ((double) totalWinnings / purchaseAmount) * 100;
    }
}
