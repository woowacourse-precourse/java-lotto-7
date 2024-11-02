package domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankResult {

    private final Map<Rank, Long> rankResult;

    public RankResult(List<Rank> ranks) {
        this.rankResult = ranks.stream()
                .collect(Collectors.groupingBy(winningLotto -> winningLotto, Collectors.counting()));
    }

    public Map<Rank, Long> getRankResult() {
        return this.rankResult;
    }
}
