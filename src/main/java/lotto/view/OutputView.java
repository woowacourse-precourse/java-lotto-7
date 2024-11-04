package lotto.view;

import lotto.domain.result.LottoRank;
import lotto.domain.result.WinningResult;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.Lottos;

public class OutputView {
    private static final String PURCHASE_RESULT_FORMAT = "\n%d개를 구매했습니다.";
    private static final String STATISTICS_HEADER = "\n당첨 통계\n---";
    private static final String WINNING_RESULT_FORMAT = "%s - %d개";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printPurchaseResult(Lottos lottos) {
        printPurchaseCount(lottos);
        printLottoNumbers(lottos);
    }

    private void printPurchaseCount(Lottos lottos) {
        System.out.printf(PURCHASE_RESULT_FORMAT, lottos.getCount());
        System.out.println();
    }

    private void printLottoNumbers(Lottos lottos) {
        lottos.forEach(this::printLotto);
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public void printWinningStatistics(WinningResult result) {
        System.out.println(STATISTICS_HEADER);
        printRankStatistics(result);
        printProfitRate(result);
    }

    private void printRankStatistics(WinningResult result) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                printRankCount(rank, result);
            }
        }
    }

    private void printRankCount(LottoRank rank, WinningResult result) {
        int count = result.getWinningCount(rank);
        System.out.printf(WINNING_RESULT_FORMAT, rank, count);
        System.out.println();
    }

    private void printProfitRate(WinningResult result) {
        System.out.printf(PROFIT_RATE_FORMAT, result.calculateProfitRate());
        System.out.println();
    }
}