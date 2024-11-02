package lotto.model;

import java.util.List;

public class LottoStatistics {
    private int totalPrize = 0;

    public void calculateResults(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        int[] results = initializeResultsArray();
        calculateLottoResults(purchasedLottos, winningLotto, results);
        printResults(results);
    }

    public double calculateYield(int totalSpent) {
        return totalSpent == 0 ? 0 : Math.round(((double) totalPrize / totalSpent) * 1000) / 10.0;
    }

    private int[] initializeResultsArray() {
        return new int[LottoRank.values().length];
    }

    private void calculateLottoResults(List<Lotto> purchasedLottos, WinningLotto winningLotto, int[] results) {
        for (Lotto lotto : purchasedLottos) {
            LottoRank rank = determineRank(winningLotto, lotto);
            results[rank.ordinal()]++;
            totalPrize += rank.getPrize();
        }
    }

    private LottoRank determineRank(WinningLotto winningLotto, Lotto lotto) {
        int matchCount = winningLotto.countMatchingNumbers(lotto);
        boolean isBonusMatched = winningLotto.isBonusNumberMatched(lotto);
        return LottoRank.findRank(matchCount, isBonusMatched);
    }

    private void printResults(int[] results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printRankResults(results);
    }

    private void printRankResults(int[] results) {
        System.out.printf("3개 일치 (5,000원) - %d개\n", results[LottoRank.FIFTH.ordinal()]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", results[LottoRank.FOURTH.ordinal()]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", results[LottoRank.THIRD.ordinal()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", results[LottoRank.SECOND.ordinal()]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", results[LottoRank.FIRST.ordinal()]);
    }
}
