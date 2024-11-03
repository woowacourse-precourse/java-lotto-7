package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class ResultAnalysis {
    private final EnumMap<Rank, Long> ranks;

    public ResultAnalysis(EnumMap<Rank, Long> ranks) {
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

        for (EnumMap.Entry<Rank, Long> entry : ranks.entrySet()) {
            Rank rank = entry.getKey();
            long count = entry.getValue();
            long totalPriceForRank = rank.getPrice() * count;
            winningPrices.add(totalPriceForRank);
        }

        return winningPrices;
    }

}
