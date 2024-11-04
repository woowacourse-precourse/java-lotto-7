package lotto.service;

import java.util.Map;
import lotto.model.LottoRule;

public class ProfitCalculator {
    public double calculateProfitRate(Map<LottoRule, Integer> matchedLotto, int amount) {
        System.out.println("당첨 통계\n---");
        int totalPrize = 0;

        for (LottoRule rule : LottoRule.values()) {
            int count = matchedLotto.getOrDefault(rule, 0);
            System.out.printf("%s - %d개\n", rule.getInfo(), count);
            totalPrize += count * rule.getPrize();
        }

        double profitRate = (double) totalPrize / amount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
        return profitRate;
    }
}
