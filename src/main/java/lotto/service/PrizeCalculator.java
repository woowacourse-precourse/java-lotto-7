package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.UserMoney;
import lotto.domain.WinningNumbers;

public class PrizeCalculator {
    private static final Map<Integer, String> prizeAmounts = Map.of(
            5, "5000",
            4, "50000",
            3, "1500000",
            2, "30000000",
            1, "2000000000"
    );

    public static Map<Integer, Integer> calculatePrizes(List<Lotto> issuedLottos, WinningNumbers winningNumbers) {
        Map<Integer, Integer> prizeCounts = initializeRankCounts();

        for (Lotto lotto : issuedLottos) {
            int rank = determinePrize(lotto, winningNumbers);
            if (rank > 0 && rank <= 5) {
                prizeCounts.put(rank, prizeCounts.get(rank) + 1);
            }
        }
        return prizeCounts;
    }

    public static double calculateProfitRate(Map<Integer, Integer> prizeCounts, UserMoney userMoney) {
        int totalPrize = prizeCounts.entrySet().stream()
                .mapToInt(entry -> Integer.parseInt(prizeAmounts.get(entry.getKey())) * entry.getValue())
                .sum();

        return (double) totalPrize / userMoney.getUserMoney() * 100;
    }

    private static Map<Integer, Integer> initializeRankCounts() {
        Map<Integer, Integer> prizeCounts = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            prizeCounts.put(i, 0);
        }
        return prizeCounts;
    }

    private static int determinePrize(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers.getWinningLotto().getNumbers()::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(winningNumbers.getBonusNumber());

        if (matchCount == 6) {
            return 1;
        }
        if (matchCount == 5 && bonusMatch) {
            return 2;
        }
        if (matchCount == 5) {
            return 3;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 3) {
            return 5;
        }
        return 0;
    }

    public static String getPrizeAmount(int rank) {
        return prizeAmounts.get(rank);
    }
}
