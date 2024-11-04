package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoManager {
    private final Map<LottoPrize, Integer> statistics = new EnumMap<>(LottoPrize.class);
    private Lotto winningLotto;
    private Integer bonusNumber;

    public LottoManager() {
        initializeStatistics();
    }

    private void initializeStatistics() {
        for (LottoPrize category : LottoPrize.values()) {
            statistics.put(category, 0);
        }
    }

    public Map<LottoPrize, Integer> getStatistics() {
        return statistics;
    }

    public void saveWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void saveBonusNumber(Integer bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (winningLotto != null && winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("Bonus number cannot be a part of winning numbers.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("Bonus number must be between 1 and 45.");
        }
    }

    public Map<LottoPrize, Integer> calculateCustomerStatistics(List<Lotto> customerLottos) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        for (Lotto lotto : customerLottos) {
            int matchCount = countMatches(lotto.getNumbers(), winningNumbers);
            updateStatistics(matchCount, lotto.getNumbers());
        }
        return statistics;
    }

    private int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void updateStatistics(int matchCount, List<Integer> lottoNumbers) {
        for (LottoPrize category : LottoPrize.values()) {
            if (category.getMatchCount() == matchCount &&
                    (category.isBonusRequired() == lottoNumbers.contains(bonusNumber))) {
                incrementCount(category);
                return;
            }
        }
    }

    private void incrementCount(LottoPrize category) {
        statistics.put(category, statistics.get(category) + 1);
    }

    public BigDecimal calculateRevenueRate(Integer payment) {
        BigDecimal totalWinnings = calculateTotalWinningAmount();
        return totalWinnings.divide(BigDecimal.valueOf(payment), 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateTotalWinningAmount() {
        return statistics.entrySet().stream()
                .map(entry -> entry.getKey().getPrizeAmount().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void clearStatistics() {
        statistics.replaceAll((key, value) -> 0);
    }
}