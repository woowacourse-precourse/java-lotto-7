package lotto.results.domain;

import lotto.purchase.domain.Money;

import java.util.Iterator;
import java.util.List;

import static lotto.common.NumberConstants.TOTAL_RANK_TYPES;

public class Results implements Iterable<Result> {

    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public String getSumOfROI(Money money) {
        return String.format("%.1f", results.stream()
                .map(result -> result.getROI(money))
                .reduce(0.0, Double::sum));
    }

    public int[] getCountOfRank() {
        int[] count = new int[TOTAL_RANK_TYPES];
        results.forEach(rank -> count[rank.rank()]++);
        return count;
    }

    @Override
    public Iterator<Result> iterator() {
        return results.iterator();
    }
}
