package lotto.view;

import lotto.model.lotto.LottoStatistics;
import lotto.model.lotto.lottoCollection;
import lotto.model.rank.LottoRank;

public class OutputView {

    public void printPurchasedLottos(lottoCollection lottoCollection) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCollection.getLottos().size());
        lottoCollection.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }


    public void printResult(LottoStatistics statistics, double earningsRate) {
        System.out.println("당첨 통계");
        System.out.println("---");

        // 각 등급을 지정된 순서로 출력
        printRankResult(statistics, LottoRank.FIFTH);    // 3개 일치
        printRankResult(statistics, LottoRank.FOURTH);   // 4개 일치
        printRankResult(statistics, LottoRank.THIRD);    // 5개 일치
        printRankResult(statistics, LottoRank.SECOND);   // 5개 일치, 보너스 볼 일치
        printRankResult(statistics, LottoRank.FIRST);    // 6개 일치

        printEarningsRate(earningsRate);
    }

    private void printRankResult(LottoStatistics statistics, LottoRank rank) {
        int count = statistics.getRankCounts().get(rank);
        String result = formatRankOutput(rank, count);
        System.out.print(result);
    }

    private String formatRankOutput(LottoRank rank, int count) {
        if (rank == LottoRank.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", rank.getMatchCount(), formatPrize(rank.getPrize()), count);
        }
        return String.format("%d개 일치 (%s원) - %d개%n", rank.getMatchCount(), formatPrize(rank.getPrize()), count);
    }

    private void printEarningsRate(double earningsRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", earningsRate);
    }

    private String formatPrize(int prize) {
        return String.format("%,d", prize);
    }


}
