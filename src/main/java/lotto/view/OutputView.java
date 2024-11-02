package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";

    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String DIVIDER = "---";

    private static final String MATCH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String MATCH_MESSAGE = "%d개 일치 (%s원) - %d개";

    private static final String TOTAL_RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void displayLottoTickets(List<Lotto> lottos) {
        System.out.printf(PURCHASE_MESSAGE + "%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void displayWinningStatistics(Map<LottoRank, Integer> statistics) {
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(DIVIDER);

        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) {
                continue;
            }

            String prizeAmount = rank.getFormattedPrizeAmount();
            int matchNumberCount = rank.getMatchNumberCount();
            int prizeWinningCount = statistics.getOrDefault(rank, 0);

            if (rank == LottoRank.SECOND) {
                System.out.printf((MATCH_BONUS_MESSAGE) + "%n", matchNumberCount, prizeAmount, prizeWinningCount);
                continue;
            }

            System.out.printf((MATCH_MESSAGE) + "%n", matchNumberCount, prizeAmount, prizeWinningCount);
        }
    }

    public static void displayProfitRate(double rateOfReturn) {
        System.out.printf(TOTAL_RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }

    public static void displayErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
