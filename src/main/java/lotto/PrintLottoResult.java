package lotto;

import java.util.List;

public class PrintLottoResult {
    public void printResults(List<List<Integer>> lottos, Lotto winningLotto, int bonusNumber, int totalSpent) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateResults(lottos, winningLotto, bonusNumber);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%d원) - %d개%n", LottoRank.FIFTH.getPrizeAmount(), lottoResult.getCount(LottoRank.FIFTH));
        System.out.printf("4개 일치 (%d원) - %d개%n", LottoRank.FOURTH.getPrizeAmount(), lottoResult.getCount(LottoRank.FOURTH));
        System.out.printf("5개 일치 (%d원) - %d개%n", LottoRank.THIRD.getPrizeAmount(), lottoResult.getCount(LottoRank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (%d원) - %d개%n", LottoRank.SECOND.getPrizeAmount(), lottoResult.getCount(LottoRank.SECOND));
        System.out.printf("6개 일치 (%d원) - %d개%n", LottoRank.FIRST.getPrizeAmount(), lottoResult.getCount(LottoRank.FIRST));

        LottoProfit lottoProfit = new LottoProfit(totalSpent, lottoResult);
        double profitRate = lottoProfit.calculateProfitRate();

        profitRate = Math.round(profitRate * 100.0) / 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}