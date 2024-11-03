package lotto.service;

import java.util.Map;
import lotto.domain.Rank;

public class WinningsCalculator {
    public long calculateTotalWinnings(Map<Rank,Integer> rankCount){
        long total = 0;
        for (Map.Entry<Rank, Integer> entry : rankCount.entrySet()){
            total += (long) entry.getKey().getPrize() * entry.getValue();
        }
        return total;
    }

    public double calculateROI(long totalWinnings, int purchaseAmount){
        double roi = ((double) totalWinnings / purchaseAmount) * 100;
        return Math.round(roi * 10.0) / 10.0;
    }
}
