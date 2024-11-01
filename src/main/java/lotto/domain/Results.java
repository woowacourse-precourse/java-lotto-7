package lotto.domain;

import java.util.Iterator;
import java.util.List;

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

    @Override
    public Iterator<Result> iterator() {
        return results.iterator();
    }
}
