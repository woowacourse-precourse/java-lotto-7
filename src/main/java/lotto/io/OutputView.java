package lotto.io;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import lotto.dto.LottoResult;
import lotto.dto.LottoTickets;
import lotto.model.LottoRank;

public class OutputView {

    private static final String DASH = "-";
    private static final String NEW_LINE = "\n";
    private static final String PURCHASED_LOTTO_TICKETS_COUNT = "%d개를 구매했습니다.";
    private static final String LOTTO_WINNING_STATISTICS = "당첨 통계";
    private static final String LOTTO_RANK_STATISTICS = "%s %s %d개%n";
    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###.#");
    private static final String TOTAL_PROFIT_RATE = "총 수익률은 %s%%입니다.";

    public void printCountOfLottoTickets(final int count) {
        printBlankLine();
        System.out.printf(PURCHASED_LOTTO_TICKETS_COUNT, count);
        printBlankLine();
    }

    public void printLottoTickets(final LottoTickets lottoTickets) {
        lottoTickets.tickets()
                .forEach(lotto -> System.out.println(lotto.getAllNumbers().toString()));
        printBlankLine();
    }

    public void printWinningStatistics(final LottoResult lottoResult) {
        System.out.println(LOTTO_WINNING_STATISTICS + NEW_LINE + DASH.repeat(3));
        lottoResult.ranks().forEach(this::printRankStatistics);
        printTotalProfitRate(lottoResult.profitRate());
    }

    public static void printExceptionMessage(final String message) {
        System.out.println(message);
        printBlankLine();
    }

    public static void printBlankLine() {
        System.out.println();
    }

    private void printRankStatistics(final LottoRank rank, final int count) {
        if (rank == LottoRank.NONE) {
            return;
        }
        System.out.printf(LOTTO_RANK_STATISTICS, rank.getResultMessage(), DASH, count);
    }

    private void printTotalProfitRate(final BigDecimal profitRate) {
        System.out.printf(TOTAL_PROFIT_RATE, decimalFormat.format(profitRate));
    }
}
