package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private static final int lottoPrice = 1000;

    private List<Lotto> lottoList;
    private Lotto winNumbers;
    private int bonusNumber;
    private Map<Rank, Integer> rankCount;

    public Map<Rank, Integer> statistic() {

        rankCount = new HashMap<>();

        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }

        for (Lotto lotto : lottoList) {
            int count = 0;
            boolean bonusCheck = false;

            for (Integer number : lotto.getNumbers()) {
                if (winNumbers.getNumbers().contains(number)) {
                    count++;
                }
            }

            if (lotto.getNumbers().contains(bonusNumber)) {
                bonusCheck = true;
            }

            for (Rank rank : Rank.values()) {
                if (count == rank.getCount() && (!rank.isNeedsBonus() || bonusCheck)) {
                    rankCount.put(rank, rankCount.get(rank) + 1);
                    break;
                }
            }
        }

        return rankCount;
    }

    private int calculateTotalPrize() {

        int totalPrize = 0;

        for (Map.Entry<Rank, Integer> entry : rankCount.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += count * rank.getPrize();
        }

        return totalPrize;
    }

    public double calculateProfitRate() {

        int totalCost = lottoList.size() * lottoPrice;
        int totalPrize = calculateTotalPrize();

        return ((double) totalPrize  / totalCost) * 100;
    }

    public Statistics(List<Lotto> lottoList, Lotto winNumbers, int bonusNumber) {
        this.lottoList = lottoList;
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }
}
