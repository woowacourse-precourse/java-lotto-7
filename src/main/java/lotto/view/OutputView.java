package lotto.view;

import static lotto.constant.MessageConstant.NEWLINE;
import static lotto.constant.MessageConstant.OUTPUT_PROFIT_RATE;
import static lotto.constant.MessageConstant.OUTPUT_PURCHASE_TICKET;
import static lotto.constant.MessageConstant.OUTPUT_PURCHASE_TICKET_INFO;
import static lotto.constant.MessageConstant.OUTPUT_WINNING_STATISTICS_HEADER;
import static lotto.constant.MessageConstant.OUTPUT_WINNING_STATISTICS_SEPARATOR;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    private static final String PROFIT_RATE_FORMAT = "#,##0.0";
    private static final DecimalFormat decimalFormat = new DecimalFormat(PROFIT_RATE_FORMAT);

    public void printPurchaseTicketCount(int count) {
        System.out.printf(NEWLINE.getMessage());
        System.out.printf(OUTPUT_PURCHASE_TICKET.getMessage(), count);
        System.out.printf(NEWLINE.getMessage());
    }

    public void printTicketNumbers(List<String> tickets) {
        tickets.forEach(ticket -> {
            System.out.printf(OUTPUT_PURCHASE_TICKET_INFO.getMessage(), ticket);
            System.out.printf(NEWLINE.getMessage());
        });
    }

    public void printWinningStatistics(List<String> results) {
        System.out.printf(NEWLINE.getMessage());
        System.out.println(OUTPUT_WINNING_STATISTICS_HEADER.getMessage());
        System.out.println(OUTPUT_WINNING_STATISTICS_SEPARATOR.getMessage());

        results.forEach(System.out::println);
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(OUTPUT_PROFIT_RATE.getMessage(), decimalFormat.format(profitRate));
    }
}
