package lotto.dto;

import lotto.domain.Ranking;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Result {

    private long totalPrice;
    private Map<Ranking,Integer> rankResults;

    private Map<Ranking, Long> countRanks(List<Ranking> ranks) {
        return ranks.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())
                );
    }
}
