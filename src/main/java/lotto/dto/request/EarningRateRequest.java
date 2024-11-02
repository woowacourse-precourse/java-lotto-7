package lotto.dto.request;

import lotto.domain.Ranking;

import java.util.Map;

public record EarningRateRequest(
        Map<Ranking, Integer> lottoResult,
        int amount
) {
    public static EarningRateRequest of(Map<Ranking, Integer> lottoResult, int amount) {
        return new EarningRateRequest(lottoResult, amount);
    }
}
