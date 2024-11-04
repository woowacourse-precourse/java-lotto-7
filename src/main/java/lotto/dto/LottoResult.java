package lotto.dto;

import static lotto.constant.Constants.DEFAULT_STATISTIC_COUNT;

import java.util.Map;
import lotto.model.Rank;

public record LottoResult(Map<Rank, Integer> rankResults, double profitRate) {
    public int getRankCount(Rank rank) {
        return rankResults.getOrDefault(rank, DEFAULT_STATISTIC_COUNT);
    }
}