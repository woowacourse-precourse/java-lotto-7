package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultAnalysis {
    private final Map<Rank, Integer> ranks;

    public ResultAnalysis(Map<Rank, Integer> ranks) {
        this.ranks = ranks;
    }

    public double getReturnRatio(long purchaseAmount) {
        double totalPrice = getTotalWinningPrice();

        return (totalPrice / purchaseAmount) * 100;
    }

    private Long getTotalWinningPrice() {
        List<Long> winningPrices = convertToWinningPrice();

        long sum = 0L;
        for (Long price : winningPrices) {
            sum += price;
        }

        return sum;
    }

    private List<Long> convertToWinningPrice() {
        List<Long> winningPrices = new ArrayList<>();

        for (Map.Entry<Rank, Integer> entry : ranks.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            long totalPriceForRank = rank.getPrice() * count;
            winningPrices.add(totalPriceForRank);
        }

        return winningPrices;
    }

}
