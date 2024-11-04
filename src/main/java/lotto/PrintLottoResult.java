package lotto;

import java.util.List;

public class PrintLottoResult {
    public void printResults(List<List<Integer>> lottos, Lotto winningLotto, int bonusNumber, int totalSpent) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateResults(lottos, winningLotto, bonusNumber);

        System.out.println("당첨 통계");
        System.out.println("---");

        StringBuilder results = new StringBuilder();
        results.append(String.format("3개 일치 (%,d원) - %d개%n", LottoRank.FIFTH.getPrizeAmount(), lottoResult.getCount(LottoRank.FIFTH)));
        results.append(String.format("4개 일치 (%,d원) - %d개%n", LottoRank.FOURTH.getPrizeAmount(), lottoResult.getCount(LottoRank.FOURTH)));
        results.append(String.format("5개 일치 (%,d원) - %d개%n", LottoRank.THIRD.getPrizeAmount(), lottoResult.getCount(LottoRank.THIRD)));
        results.append(String.format("5개 일치, 보너스 볼 일치 (%,d원) - %d개%n", LottoRank.SECOND.getPrizeAmount(), lottoResult.getCount(LottoRank.SECOND)));
        results.append(String.format("6개 일치 (%,d원) - %d개%n", LottoRank.FIRST.getPrizeAmount(), lottoResult.getCount(LottoRank.FIRST)));

        LottoProfit lottoProfit = new LottoProfit(totalSpent, lottoResult);
        double profitRate = lottoProfit.calculateProfitRate();

        profitRate = Math.round(profitRate * 100.0) / 100.0;
        results.append(String.format("총 수익률은 %.1f%%입니다.%n", profitRate));

        System.out.print(results);
    }
}