package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Result {

    private static final Integer LOTTO_PRICE = 1000;

    private long totalPrice;
    private double profitRate;
    private Map<Ranking,Long> rankResults;

    public Result(List<Ranking> ranks) {
        this.totalPrice = calcTotalPrice(ranks);
        this.rankResults = countRanks(ranks);
        this.profitRate = calcProfitRate(ranks);
    }

    private Map<Ranking, Long> countRanks(List<Ranking> ranks) {
        Map<Ranking, Long> result = Arrays.stream(Ranking.values())
                .collect(Collectors.toMap(Function.identity(), rank -> 0L));

        ranks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach(result::put);
        return result;
    }

    private long calculatePaidAmount(List<Ranking> ranks) {
        return ranks.size() * LOTTO_PRICE;
    }

    private double calcProfitRate(List<Ranking> ranks) {
        long amount = calculatePaidAmount(ranks);
        return (double) totalPrice / amount * 100;
    }

    private long calcTotalPrice(List<Ranking> ranks) {
        return ranks.stream()
                .mapToLong(Ranking::getPrice)
                .sum();
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public Map<Ranking, Long> getRankResults() {
        return rankResults;
    }
}
