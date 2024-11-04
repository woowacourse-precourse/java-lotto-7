package lotto.ui.output;

import lotto.domain.entity.Lottos;
import lotto.domain.rank.LottoRank;

import java.util.Map;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printLottos(final Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> {
            System.out.println(lotto.numbers());
        });
    }

    @Override
    public void winningStats(final Lottos lottos, final int profit) {
        System.out.println("당첨 통계");
        System.out.println("---");

        final Map<LottoRank, Long> rankCounts = lottos.calculateRankCounts();

        long totalCost = lottos.lottos().size() * 1000L;
        double totalYield = ((double) profit / totalCost) * 100;

        // 각 랭크에 대한 통계를 출력
        System.out.printf("3개 일치 (5,000원) - %,d개%n", rankCounts.getOrDefault(LottoRank.FIFTH, 0L));
        System.out.printf("4개 일치 (50,000원) - %,d개%n", rankCounts.getOrDefault(LottoRank.FOURTH, 0L));
        System.out.printf("5개 일치 (1,500,000원) - %,d개%n", rankCounts.getOrDefault(LottoRank.THIRD, 0L));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %,d개%n", rankCounts.getOrDefault(LottoRank.SECOND, 0L));
        System.out.printf("6개 일치 (2,000,000,000원) - %,d개%n", rankCounts.getOrDefault(LottoRank.FIRST, 0L));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", totalYield);
    }
}
