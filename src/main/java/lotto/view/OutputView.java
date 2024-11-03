package lotto.view;

import lotto.domain.Rank;
import lotto.dto.FormattedTickets;
import lotto.utils.RankPrizeFormatter;

import java.math.BigDecimal;

public class OutputView {
    private static final String PURCHASE_TOTAL_PRICE_PROMPT = "구입 금액을 입력해 주세요.";
    private static final String PURCHASED_TICKET_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_NUMBERS_INPUT_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String STATISTICS_DIVIDER = "---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printPurchaseTotalPricePrompt() {
        System.out.println(PURCHASE_TOTAL_PRICE_PROMPT);
    }

    public void printPurchasedTicketCount(int count) {
        System.out.printf((PURCHASED_TICKET_COUNT_MESSAGE) + "%n", count);
    }

    public void printFormattedTickets(FormattedTickets formattedTickets) {
        formattedTickets.formattedTickets().forEach(System.out::println);
        System.out.println();
    }

    public void printLottoNumbersInputPrompt() {
        System.out.println(LOTTO_NUMBERS_INPUT_PROMPT);
    }

    public void printBonusNumberInputPrompt() {
        System.out.println(BONUS_NUMBER_INPUT_PROMPT);
    }

    public void printWinningStatisticsHeader() {
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(STATISTICS_DIVIDER);
    }

    public void printRankStatistics(Rank rank, int count) {
        String formattedStatistics = RankPrizeFormatter.formatRankStatistics(rank, count);
        System.out.println(formattedStatistics);
    }

    public void printProfitRate(BigDecimal profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE + "%n", profitRate);
    }
}
