package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoManager {
    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;

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
            throw new IllegalArgumentException("보너스 번호는 당첨 번호에 포함될 수 없습니다.");
        }
        if (bonusNumber < MIN_BONUS_NUMBER || bonusNumber > MAX_BONUS_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 " + MIN_BONUS_NUMBER + "부터 " + MAX_BONUS_NUMBER + " 사이의 숫자여야 합니다.");
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