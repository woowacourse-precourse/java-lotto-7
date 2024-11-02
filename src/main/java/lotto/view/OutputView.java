package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";

    private static final String LOTTO_STATS_HEADER = "당첨 통계";
    private static final String DIVIDER = "---";

    private static final String SECOND_RANK_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String GENERAL_RANK_MESSAGE = "%d개 일치 (%s원) - %d개";

    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void displayLottoTickets(List<Lotto> lottoTickets) {
        System.out.printf(PURCHASE_MESSAGE + "%n", lottoTickets.size());
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getNumbers());
        }
    }

    public static void displayLottoStats(Map<LottoRank, Integer> lottoStats) {
        System.out.println(LOTTO_STATS_HEADER);
        System.out.println(DIVIDER);

        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) {
                continue;
            }

            int matchNumberCount = rank.getMatchNumberCount();
            String prizeAmount = rank.getFormattedPrizeAmount();
            int prizeWinningCount = lottoStats.getOrDefault(rank, 0);

            if (rank == LottoRank.SECOND) {
                System.out.printf((SECOND_RANK_MESSAGE) + "%n", matchNumberCount, prizeAmount, prizeWinningCount);
                continue;
            }

            System.out.printf((GENERAL_RANK_MESSAGE) + "%n", matchNumberCount, prizeAmount, prizeWinningCount);
        }
    }

    public static void displayProfitRate(double rateOfReturn) {
        System.out.printf(PROFIT_RATE_MESSAGE, rateOfReturn);
    }

    public static void displayErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
