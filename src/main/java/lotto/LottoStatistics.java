package lotto;

import java.util.*;

public class LottoStatistics {
    private final Map<LottoRank, Integer> statistics = new HashMap<>();
    private int totalPrize = 0;

    public LottoStatistics(List<List<Integer>> userLottos, List<Integer> winningNumbers, int bonusNumber) {
        calculateStatistics(userLottos, winningNumbers, bonusNumber);
    }

    private void calculateStatistics(List<List<Integer>> userLottos, List<Integer> winningNumbers, int bonusNumber) {
        for (List<Integer> lotto : userLottos) {
            updateStatistics(lotto, winningNumbers, bonusNumber);
        }
    }

    private void updateStatistics(List<Integer> lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.stream().filter(winningNumbers::contains).count();
        boolean bonusMatch = lotto.contains(bonusNumber);

        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
        if (rank == LottoRank.NONE) {
            return;
        }
        statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        totalPrize += rank.getPrize();
    }

    public void printStatistics(int purchaseAmount) {
        printHeader();
        printRankStatistics();
        printYield(purchaseAmount);
    }

    private void printHeader() {
        System.out.println("\n당첨 통계\n---");
    }

    private void printRankStatistics() {
        Arrays.stream(LottoRank.values())
                .sorted(Comparator.comparingInt(LottoRank::getMatchCount)
                        .thenComparing(LottoRank::isBonusMatch))
                .forEach(this::printRankDetails);
    }

    private void printRankDetails(LottoRank rank) {
        if (rank == LottoRank.NONE) {
            return;
        }
        int count = statistics.getOrDefault(rank, 0);
        String description = formatRankDescription(rank, count);
        System.out.println(description);
    }

    private String formatRankDescription(LottoRank rank, int count) {
        if (rank == LottoRank.SECOND_PRIZE) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                    rank.getMatchCount(),
                    String.format("%,d", rank.getPrize()),
                    count);
        }
        return String.format("%d개 일치 (%s원) - %d개",
                rank.getMatchCount(),
                String.format("%,d", rank.getPrize()),
                count);
    }

    private void printYield(int purchaseAmount) {
        double yield = calculateYield(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    private double calculateYield(int purchaseAmount) {
        return ((double) totalPrize / purchaseAmount) * 100;
    }
}
