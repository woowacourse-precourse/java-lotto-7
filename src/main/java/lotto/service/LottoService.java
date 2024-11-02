package lotto.service;

import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.WinningNumber;

import java.util.List;

public class LottoService {
    private static final int[] PRIZE_AMOUNTS = {5000, 50000, 1500000, 30000000, 2000000000};

    public int[] calculateStatistics(List<Lotto> lottos, WinningNumber winningNumber) {
        int[] matchCounts = new int[5];

        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto, winningNumber);
            if (matchCount >= 3 && matchCount <= 6) {
                matchCounts[matchCount - 3]++;
            }
        }
        return matchCounts;
    }

    public double calculateYield(Money money, int[] matchCounts) {
        int totalPrize = 0;
        for (int i = 0; i < matchCounts.length; i++) {
            totalPrize += matchCounts[i] * PRIZE_AMOUNTS[i];
        }
        return (double) totalPrize / money.getAmount() * 100;
    }

    public int countMatchingNumbers(Lotto userLotto, WinningNumber winningNumber) {
        return (int) userLotto.getNumbers().stream()
                .filter(winningNumber.getNumbers()::contains)
                .count();
    }
}
