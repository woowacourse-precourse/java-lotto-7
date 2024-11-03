package lotto.model.domain;

import static lotto.message.ErrorMessage.BONUS_NUMBER_DUPLICATE;
import static lotto.message.ErrorMessage.INVALID_BONUS_NUMBER_RANGE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    private final Map<String, Integer> statistics = new HashMap<>();
    private Lotto winningLotto;
    private Integer bonusNumber;

    public LottoManager() {
        statistics.put("3", 0);
        statistics.put("4", 0);
        statistics.put("5", 0);
        statistics.put("5B", 0);
        statistics.put("6", 0);
    }

    public Map<String, Integer> getStatistics() {
        return statistics;
    }

    public Lotto saveWinningLotto(Lotto winningLotto) {
        return this.winningLotto = winningLotto;
    }

    public Integer saveBonusNumber(Integer bonusNumber) {
        validateBonusNumberDuplication(bonusNumber);
        validateRange(bonusNumber);
        return this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberDuplication(Integer bonusNumber) {
        if (winningLotto != null && winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    private void validateRange(Integer number) {
        if (!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    public Map<String, Integer> statisticsCustomerWinning(List<Lotto> customerLottos) {
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
        if (matchCount == 6) {
            incrementCount("6");
            return;
        }

        if (matchCount == 5) {
            updateFiveMatchesCount(lottoNumbers);
            return;
        }

        if (matchCount == 4) {
            incrementCount("4");
            return;
        }

        if (matchCount == 3) {
            incrementCount("3");
        }
    }

    private void updateFiveMatchesCount(List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNumber)) {
            incrementCount("5B");
            return;
        }
        incrementCount("5");
    }

    private void incrementCount(String key) {
        statistics.put(key, statistics.get(key) + 1);
    }

    public BigDecimal getRateOfRevenue(Integer payment) {
        return calculateTotalWinningAmount()
                .divide(BigDecimal.valueOf(payment), 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateTotalWinningAmount() {
        Map<String, BigDecimal> prizeAmounts = Map.of(
                "3", BigDecimal.valueOf(5000),
                "4", BigDecimal.valueOf(50000),
                "5", BigDecimal.valueOf(1500000),
                "5B", BigDecimal.valueOf(30000000),
                "6", BigDecimal.valueOf(2000000000)
        );

        return prizeAmounts.entrySet().stream()
                .map(this::calculatePrizeTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculatePrizeTotal(Map.Entry<String, BigDecimal> entry) {
        return BigDecimal.valueOf(statistics.get(entry.getKey()))
                .multiply(entry.getValue());
    }

    public void clearCustomerWinningDetails() {
        statistics.clear();
    }
}
