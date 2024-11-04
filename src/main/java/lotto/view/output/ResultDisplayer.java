package lotto.view.output;

import java.util.Map;
import lotto.constatnt.WinningRank;
import lotto.model.Lottos;

public class ResultDisplayer {

    private static final String LOTTO_COUNT_MESSAGE_SUFFIX = "개를 구매했습니다.";
    private static final String YIELD_MESSAGE = "총 수익률은 ";

    public void showPurchasedLottos(int lottoCount, Lottos lottos) {
        System.out.println(lottoCount + LOTTO_COUNT_MESSAGE_SUFFIX);
        lottos.getLottos().forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }

    public void showWinningStatistics(Map<WinningRank, Integer> winningCounts) {
        System.out.println("---");

        winningCounts.forEach((rank, count) -> {
            if (rank == WinningRank.SECOND_PRIZE_WITH_BONUS) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n",
                        rank.getRequiredMatchingCount(),
                        rank.getPrizeAmount(),
                        count);
            } else if (rank != WinningRank.NO_PRIZE) {
                System.out.printf("%d개 일치 (%,d원) - %d개%n",
                        rank.getRequiredMatchingCount(),
                        rank.getPrizeAmount(),
                        count);
            }
        });
    }

    public void showYield(double yield) {
        System.out.printf("%s%.1f%%입니다.%n", YIELD_MESSAGE, yield);
    }
}
