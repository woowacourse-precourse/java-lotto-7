package lotto.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import lotto.util.LottoResultChecker;

public class LottoManager {
    private static final Rank NONE_RANK_FILTER = Rank.NONE;
    private static final long INITIAL_RANK_COUNT = 0L;
    private static final int PERCENTAGE_MULTIPLIER = 100;

    private final Lottos lottos;
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;
    private final Map<Rank, Long> results;

    private LottoManager(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.results = calculateResults();
    }

    public static LottoManager of(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new LottoManager(lottos, winningNumbers, bonusNumber);
    }

    private Map<Rank, Long> calculateResults() {
        Map<Rank, Long> results = initializeResultsMap();
        updateRankCount(results);
        return results;
    }

    private Map<Rank, Long> initializeResultsMap() {
        Map<Rank, Long> results = new LinkedHashMap<>();
        Arrays.stream(Rank.values())
                .filter(rank -> rank != NONE_RANK_FILTER)
                .forEach(rank -> results.put(rank, INITIAL_RANK_COUNT));
        return results;
    }

    private void updateRankCount(Map<Rank, Long> results) {
        lottos.getLottos().stream()
                .map(this::getRank)
                .filter(rank -> rank != NONE_RANK_FILTER)
                .forEach(rank -> results.put(rank, results.get(rank) + 1));
    }

    private Rank getRank(Lotto lotto) {
        int matchCount = LottoResultChecker.countMatchingNumbers(lotto.getNumbers(), winningNumbers.winningNumbers());
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber.getBonusNumber());

        return Rank.determineRank(matchCount, hasBonus);
    }

    public double calculateRateOfReturn(int purchaseAmount) {
        long totalWinningAmount = calculateTotalWinningPrizesAmount();
        return (double) totalWinningAmount / purchaseAmount * PERCENTAGE_MULTIPLIER;
    }

    private long calculateTotalWinningPrizesAmount() {
        return results.entrySet().stream()
                .mapToLong(entry -> entry.getValue() * entry.getKey().getPrize())
                .sum();
    }

    public Map<Rank, Long> getResults() {
        return results;
    }
}
