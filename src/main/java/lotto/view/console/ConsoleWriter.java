package lotto.view.console;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningResult;
import lotto.view.OutputView;

public class ConsoleWriter implements OutputView {
    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String STATISTICS_SEPARATOR = "---";
    private static final String RANK_COUNT_MESSAGE = "%d개 일치 (%,d원) - %d개%n";
    private static final String BONUS_COUNT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.%n";

    @Override
    public void printPurchasedLottoCount(int count) {
        System.out.println();
        System.out.printf(PURCHASED_LOTTO_COUNT_MESSAGE + "%n", count);
    }

    @Override
    public void printLottoTickets(Lottos lottos) {
        for (Lotto lotto : lottos.getTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }

    @Override
    public void printResults(WinningResult winningResult) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(STATISTICS_SEPARATOR);

        for (Rank rank : Rank.getWithoutNone()) {
            int count = winningResult.getCount(rank);

            if (rank == Rank.SECOND) {
                System.out.printf(BONUS_COUNT_MESSAGE, rank.getMatch(), rank.getPrize(), count);
                continue;
            }

            System.out.printf(RANK_COUNT_MESSAGE, rank.getMatch(), rank.getPrize(), count);
        }
    }

    @Override
    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }
}
