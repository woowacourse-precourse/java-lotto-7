package lotto.model;

import java.util.Iterator;
import java.util.List;

public class Prize {
    double profitRate;

    public void checkProfitResult(Status status) {
        List<Integer> numbersHitStatus = status.getNumbersHit();
        List<Boolean> bonusHitStatus = status.getBonusHit();

        Iterator<Integer> numbersHit = numbersHitStatus.iterator();
        Iterator<Boolean> bonusHit = bonusHitStatus.iterator();

        while (numbersHit.hasNext() && bonusHit.hasNext()) {
            int hits = numbersHit.next();
            boolean isBonusHit = bonusHit.next();

            Ranks.checkRanks(hits, isBonusHit);
        }
    }

    public void checkProfitRate(Tickets tickets) {
        int investAmount = tickets.getInvestAmount();
        double totalPrizeAmount = 0.0;

        for (Ranks rank : Ranks.values()) {
            int rankCount = rank.getCount();
            int rankReward = rank.getReward();

            totalPrizeAmount += (rankReward * rankCount);
        }
        profitRate = (totalPrizeAmount / investAmount) * 100;
    }
    
    public double getProfitRate() {
        return profitRate;
    }
}