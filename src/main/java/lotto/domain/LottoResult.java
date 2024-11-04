package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import lotto.dto.ResultDto;

public class LottoResult {

    private final EnumMap<Rank, Integer> results;

    private LottoResult(List<Rank> ranks) {
        this.results = new EnumMap<>(Rank.class);
        ranks.forEach(rank -> results.put(rank, results.getOrDefault(rank, 0) + 1));
    }

    public static LottoResult createResult(List<Rank> ranks) {
        return new LottoResult(ranks);
    }

    public ResultDto getResults() {
        return ResultDto.toDto(results);
    }

    public Long getTotalPrize() {
        return results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Double calculateRevenueRate(int payment) {
        return ((double) getTotalPrize() / payment) * 100;
    }

}
