package lotto.ui.output;

import lotto.domain.entity.Lotto;
import lotto.domain.rank.LottoRank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printLottos(final List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> {
            System.out.println(lotto.toString());
        });
    }

    @Override
    public void winningStats(final List<Lotto> ranks, final int profit) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<LottoRank, Long> rankCounts = ranks.stream()
                .collect(Collectors.groupingBy(Lotto::getRank, Collectors.counting()));

        long totalCost = ranks.size() * 1000L;
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
