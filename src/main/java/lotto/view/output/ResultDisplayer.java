package lotto.view.output;

import java.util.Map;
import lotto.constatnt.WinningRank;
import lotto.model.Lottos;

public class ResultDisplayer {

    private static final String LOTTO_COUNT_MESSAGE_SUFFIX = "개를 구매했습니다.";
    private static final String YIELD_MESSAGE = "총 수익률은 ";
    private static final String MATCH_COUNT_MESSAGE = "%d개 일치";
    private static final String MATCH_COUNT_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치";
    private static final String PRIZE_MESSAGE = "(%,d원) - %d개%n";
    private static final String STATISTICS_HEADER = "당첨 통계";
    private static final String SEPARATOR = "---";

    public void showPurchasedLottos(int lottoCount, Lottos lottos) {
        System.out.println();
        System.out.println(lottoCount + LOTTO_COUNT_MESSAGE_SUFFIX);
        lottos.getLottos().forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }

    public void showWinningStatistics(Map<WinningRank, Integer> winningCounts) {
        System.out.println();
        System.out.println(STATISTICS_HEADER);
        System.out.println(SEPARATOR);

        for (WinningRank rank : WinningRank.values()) {
            if (rank == WinningRank.SECOND_PRIZE_WITH_BONUS) {
                System.out.printf(MATCH_COUNT_WITH_BONUS_MESSAGE + " " + PRIZE_MESSAGE,
                        rank.getRequiredMatchingCount(),
                        rank.getPrizeAmount(),
                        winningCounts.getOrDefault(rank, 0));
            }
            if (rank != WinningRank.NO_PRIZE && rank != WinningRank.SECOND_PRIZE_WITH_BONUS) {
                System.out.printf(MATCH_COUNT_MESSAGE + " " + PRIZE_MESSAGE,
                        rank.getRequiredMatchingCount(),
                        rank.getPrizeAmount(),
                        winningCounts.getOrDefault(rank, 0));
            }
        }
    }

    public void showYield(double yield) {
        System.out.printf("%s%.1f%%입니다.%n", YIELD_MESSAGE, yield);
    }
}
