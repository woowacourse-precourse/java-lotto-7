package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Settlement {

    private final Buyer buyer;
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public Settlement(Buyer buyer, List<Integer> winningNumber, int bonusNumber) {
        this.buyer = buyer;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> getWinningDetails() {
        Map<Rank, Integer> details = new LinkedHashMap<>();
        List<Rank> ranks = buyer.getRanks(winningNumber, bonusNumber);

        for (Rank rank : ranks) {
            details.put(rank, details.getOrDefault(rank, 0) + 1);
        }
        return details;
    }

    public double getProfitRate() {
        List<Rank> ranks = buyer.getRanks(winningNumber, bonusNumber);

        long sum = 0L;
        for (Rank rank : ranks) {
            sum += rank.getWinningAmount();
        }
        return Math.round((double) sum / buyer.getAmount() * 100 * 10) / 10.0;
    }
}
