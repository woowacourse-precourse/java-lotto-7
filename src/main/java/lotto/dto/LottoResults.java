package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.Rank;

public class LottoResults {
    public static final int PRICE = 1000;

    private final List<LottoResult> results;

    private LottoResults(List<LottoResult> results) {
        this.results = results;
    }

    public static LottoResults of(List<LottoResult> results) {
        return new LottoResults(results);
    }

    public long getNumberOfMatched(Rank rank) {
        return results.stream().
                filter(result -> isMatchingRank(rank, result))
                .count();
    }

    private boolean isMatchingRank(Rank rank, LottoResult result) {
        return result.getRank() == rank;
    }

    public double getPercentageOfMatched() {
        return getTotalPrize() / getPurchase() * 100;
    }

    private double getTotalPrize() {
        return results.stream().mapToDouble(result -> {
            Rank rank = result.getRank();
            return rank.getPrizeMoney();
        }).sum();
    }

    private int getPurchase() {
        return results.size() * PRICE;
    }

    public List<LottoResult> getResults() {
        return new ArrayList<>(results);
    }
}
