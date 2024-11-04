package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {
    private final static int ROUNDING_DIGIT = 2;

    private final Map<LottoRanking, Integer> rankingResult = new LinkedHashMap<>();
    private final double rateOfReturn;
    private final Budget budget;
    private final BonusNumber bonusNumber;

    public LottoResult(Lottos lottos, WinningNumbers winningNumbers, Budget budget, BonusNumber bonusNumber) {
        init();
        update(lottos, winningNumbers, bonusNumber);
        this.budget = budget;
        this.rateOfReturn = calculateRateOfReturn(budget);
        this.bonusNumber = bonusNumber;
    }

    private void init() {
        for (LottoRanking ranking : LottoRanking.values()) {
            rankingResult.put(ranking, 0);
        }
    }

    private void update(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            LottoRanking ranking = LottoRanking
                    .getRank(winningNumbers.getCurrentNumberCount(lotto), bonusNumber.isIn(lotto));
            rankingResult.replace(ranking, rankingResult.get(ranking) + 1);
        }
    }

    private double calculateRateOfReturn(Budget budget) {
        int totalBudgetSpent = budget.getBudget();
        long totalPrize = rankingResult.entrySet()
                .stream()
                .mapToLong(rank -> rank.getKey().getReward() * rank.getValue())
                .sum();

        return round(((double) totalPrize / totalBudgetSpent) * 100);
    }

    private double round(double value) {
        BigDecimal profit = BigDecimal.valueOf(value);
        profit = profit.setScale(ROUNDING_DIGIT, RoundingMode.HALF_UP);
        return profit.doubleValue();
    }

    public Map<LottoRanking, Integer> getResult() {
        return Collections.unmodifiableMap(rankingResult);
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
