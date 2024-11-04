package lotto.service;

import java.util.Map;
import lotto.model.LottoRule;

public class ProfitCalculator {

    private static final Integer PERCENT = 100;
    public double calculateProfitRate(Map<LottoRule, Integer> matchedLotto, int amount) {
        int totalPrize = 0;

        for (LottoRule rule : LottoRule.values()) {
            int count = matchedLotto.getOrDefault(rule, 0);
            totalPrize += count * rule.getPrize();
        }

        return (double) totalPrize / amount * PERCENT;
    }
}
