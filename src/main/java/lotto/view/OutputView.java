package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class OutputView {
    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
        }

    public void printWinningStats(Map<LottoRank, Integer> winningStats) {
        System.out.println("당첨 통계");
        System.out.println("---");
        winningStats.forEach((rank, count) -> {
            if (rank != LottoRank.NONE) {
                System.out.printf("%d개 일치 (%d원) - %d개%n",
                        rank.getMatchCount(),
                        rank.getPrizeMoney(),
                        count);
            }
        });

    }

    public void printYield(double yield) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        String formattedYield = decimalFormat.format(yield);
        System.out.printf("총 수익률은 %s%%입니다.%n", formattedYield);
    }
}

