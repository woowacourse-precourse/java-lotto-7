package lotto.service;

import static lotto.constant.Constants.DEFAULT_STATISTIC_COUNT;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.LottoPurchase;
import lotto.dto.LottoResult;
import lotto.model.Lotto;
import lotto.model.Rank;

public class LottoResultService {

    public LottoResult calculateLottoResult(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber,
                                            LottoPurchase lottoPurchase) {
        Map<Rank, Integer> rankResults = calculateResults(purchasedLottos, winningNumbers, bonusNumber);
        double profitRate = calculateProfitRate(rankResults, lottoPurchase.amount());
        return new LottoResult(rankResults, profitRate);
    }

    private Map<Rank, Integer> calculateResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers,
                                                int bonusNumber) {
        Map<Rank, Integer> results = new HashMap<>();
        purchasedLottos.forEach(lotto -> updateResults(results, lotto, winningNumbers, bonusNumber));
        return results;
    }

    private void updateResults(Map<Rank, Integer> results, Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        Rank rank = determineRank(lotto, winningNumbers, bonusNumber);
        results.putIfAbsent(rank, DEFAULT_STATISTIC_COUNT);
        results.put(rank, results.get(rank) + 1);
    }

    private Rank determineRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = calculateMatchCount(lotto, winningNumbers);
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
        return Rank.getRank(matchCount, hasBonus);
    }

    private int calculateMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public double calculateProfitRate(Map<Rank, Integer> results, int purchaseAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        double rawProfitRate = (double) totalPrize / purchaseAmount * 100;
        return BigDecimal.valueOf(rawProfitRate)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
    }
}