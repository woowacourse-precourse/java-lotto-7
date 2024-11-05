package lotto.view;

import java.util.List;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoTicketsDto;
import lotto.utils.RankMessages;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_HEADER = "\n당첨 통계\n---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s\n";

    public static void printLottoTickets(List<LottoTicketsDto> lottoTickets) {
        System.out.println("\n"+lottoTickets.size()+PURCHASE_MESSAGE);
        lottoTickets.forEach(tickets -> System.out.println(tickets.getNumbers()));
    }

    public static void printLottoResults(LottoResultDto result) {
        System.out.println(WINNING_STATISTICS_HEADER);
        printRankResults(result);
        printProfitRate(result.getProfitRate());
    }

    private static void printRankResults(LottoResultDto result) {
        result.getRankCounts().forEach((rank, count) -> {
            if (rank.getPrize() > 0) {
                String message = RankMessages.getMessage(rank.getMatchCount(), rank.isMatchBonus());
                String formattedPrize = formatPrize(rank.getPrize());
                System.out.printf("%s (%s원) - %d개\n", message, formattedPrize, count);
            }
        });
    }

    private static void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE+"\n", profitRate);
    }

    private static String formatPrize(long prize) {
        return String.format("%,d", prize);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.printf(ERROR_MESSAGE_FORMAT, errorMessage);
    }
}