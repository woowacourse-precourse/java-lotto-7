package domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankResult {

    private final Map<Rank, Long> rankResult;

    public RankResult(List<Rank> ranks) {
        this.rankResult = rankCounting(ranks);
    }

    private Map<Rank, Long> rankCounting(List<Rank> ranks) {
        return ranks.stream()
                .collect(Collectors.groupingBy(winningLotto -> winningLotto, Collectors.counting()));
    }

    public Map<Rank, Long> getRankResult() {
        return this.rankResult;
    }
}
