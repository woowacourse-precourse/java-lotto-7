package lotto.model;

import java.util.List;

public class LottoStatistics {
    private int totalPrize = 0;

    public void calculateResults(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        int[] results = new int[LottoRank.values().length];

        for (Lotto lotto : purchasedLottos) {
            int matchCount = winningLotto.countMatchingNumbers(lotto);
            boolean isBonusMatched = winningLotto.isBonusNumberMatched(lotto);
            LottoRank rank = LottoRank.findRank(matchCount, isBonusMatched);

            results[rank.ordinal()]++;
            totalPrize += rank.getPrize();
        }

        printResults(results);
    }

    public double calculateYield(int totalSpent) {
        if (totalSpent == 0) return 0;
        return Math.round(((double) totalPrize / totalSpent) * 1000) / 10.0;
    }

    private void printResults(int[] results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", results[LottoRank.FIFTH.ordinal()]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", results[LottoRank.FOURTH.ordinal()]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", results[LottoRank.THIRD.ordinal()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", results[LottoRank.SECOND.ordinal()]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", results[LottoRank.FIRST.ordinal()]);
    }
}