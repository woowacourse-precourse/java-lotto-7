package lotto.domain;

public class WinningStatisticsCalculator {

    public static WinningStatistics calculateStatistics(Lottos lottos, Lotto winningNumbers, int bonusNumber) {
        WinningStatistics winningStatistics = new WinningStatistics();

        for (Lotto lotto : lottos.lottos()) {
            long matchCount = calculateMatchCount(lotto, winningNumbers);
            boolean bonusMatch = isBonusMatch(lotto, bonusNumber);
            updateStatistics(matchCount, bonusMatch, winningStatistics);
        }

        return winningStatistics;
    }

    private static long calculateMatchCount(Lotto lotto, Lotto winningNumbers) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    private static boolean isBonusMatch(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private static void updateStatistics(long matchCount, boolean bonusMatch, WinningStatistics winningStatistics) {
        for (WinningRank rank : WinningRank.values()) {
            if (rank.isMatch(matchCount, bonusMatch)) {
                winningStatistics.incrementRankCount(rank);
            }
        }
    }

    public static double calculateReturnRate(WinningStatistics winningStatistics, int purchaseAmount) {
        int totalPrizeMoney = calculateTotalPrizeMoney(winningStatistics);
        return ((double) totalPrizeMoney / purchaseAmount) * 100;
    }

    private static int calculateTotalPrizeMoney(WinningStatistics winningStatistics) {
        return winningStatistics.getStatistics().entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

}

