package lotto.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import lotto.util.LottoResultChecker;

public class LottoManager {
    private final Lottos lottos;
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;
    private final Map<Rank, Long> results;

    public LottoManager(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.results = calculateResults();
    }

    private Map<Rank, Long> calculateResults() {
        Map<Rank, Long> results = initializeResultsMap();
        updateRankCount(results);
        return results;
    }

    private Map<Rank, Long> initializeResultsMap() {
        Map<Rank, Long> results = new LinkedHashMap<>();
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> results.put(rank, 0L));
        return results;
    }

    private void updateRankCount(Map<Rank, Long> results) {
        lottos.getLottos().stream()
                .map(this::getRank)
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> results.put(rank, results.get(rank) + 1));
    }

    private Rank getRank(Lotto lotto) {
        int matchCount = LottoResultChecker.countMatchingNumbers(lotto.getNumbers(), winningNumbers.winningNumbers());
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber.getBonusNumber());
        return Rank.determineRank(matchCount, hasBonus);
    }

    public Double calculateRateOfReturn(int purchaseAmount) {
        long totalWinningAmount = calculateTotalWinningAmount();
        return (double) totalWinningAmount / purchaseAmount * 100; // 수익률 계산
    }

    private long calculateTotalWinningAmount() {
        long totalWinningAmount = 0;

        for (Map.Entry<Rank, Long> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            long count = entry.getValue();

            totalWinningAmount += count * rank.getPrize();
        }

        return totalWinningAmount;
    }

    public Map<Rank, Long> getResults() {
        return results;
    }
}
