package lotto.service;

import lotto.dto.LottoWinningResult;
import lotto.dto.LottoGameResultDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatisticsService {
    public Map<LottoWinningResult, Integer> getLottoStatistics(List<Map<Integer, Boolean>> resultList) {
        Map<LottoWinningResult, Integer> resultCounts = new HashMap<>();
        resultList.forEach(result -> result.forEach((matchCount, bonusMatch) -> {
            LottoWinningResult lottoWinningResult = findByMatch(matchCount, bonusMatch);
            if (lottoWinningResult != null) {
                resultCounts.put(lottoWinningResult, resultCounts.getOrDefault(lottoWinningResult, 0) + 1);
            }
        }));
        return resultCounts;
    }

    private LottoWinningResult findByMatch(int matchCount, boolean bonusMatched) {
        for (LottoWinningResult lottoWinningResult : LottoWinningResult.values()) {
            if (lottoWinningResult.getMatchCount() == matchCount && lottoWinningResult.isBonusMatched() == bonusMatched) {
                return lottoWinningResult;
            }
        }
        return null;
    }

    public double calculateWinningRate(LottoGameResultDto lottoGameResultDto, Map<LottoWinningResult, Integer> printResultList) {
        long totalPrize = getTotalPrize(printResultList);
        int cost = lottoGameResultDto.getPurchaseQuantity() * 1000;
        return getWinningRate(cost, totalPrize);
    }

    private long getTotalPrize(Map<LottoWinningResult, Integer> printResultList) {
        return printResultList.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private double getWinningRate(int cost, long totalPrize) {
        return ((double) totalPrize / cost) * 100;
    }
}
