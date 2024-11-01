package lotto.service;

import lotto.dto.LottoResult;
import lotto.dto.LottoResultDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatisticsService {
    public Map<LottoResult, Integer> getLottoStatistics(List<Map<Integer, Boolean>> resultList) {
        Map<LottoResult, Integer> resultCounts = new HashMap<>();
        resultList.forEach(result -> result.forEach((matchCount, bonusMatch) -> {
            LottoResult lottoResult = findByMatch(matchCount, bonusMatch);
            if (lottoResult != null) {
                resultCounts.put(lottoResult, resultCounts.getOrDefault(lottoResult, 0) + 1);
            }
        }));
        return resultCounts;
    }

    private LottoResult findByMatch(int matchCount, boolean bonusMatched) {
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult.getMatchCount() == matchCount && lottoResult.isBonusMatched() == bonusMatched) {
                return lottoResult;
            }
        }
        return null;
    }

    public double calculateWinningRate(LottoResultDto lottoResultDto, Map<LottoResult, Integer> printResultList) {
        long totalPrize = getTotalPrize(printResultList);
        int cost = lottoResultDto.getPurchaseQuantity() * 1000;
        return getWinningRate(cost, totalPrize);
    }

    private long getTotalPrize(Map<LottoResult, Integer> printResultList) {
        return printResultList.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private double getWinningRate(int cost, long totalPrize) {
        return ((double) totalPrize / cost) * 100;
    }
}
