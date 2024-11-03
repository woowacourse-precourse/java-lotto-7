package lotto.view;

import static lotto.constant.MessageConstant.*;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    private static final String PROFIT_RATE_FORMAT = "#,##0.0";

    public void printTicketCount(int count) {
        System.out.println();
        System.out.printf(OUTPUT_PURCHASE_TICKET.getMessage(), count);
        System.out.println();
    }

    public void printTicketNumbers(List<String> tickets) {
        tickets.forEach(ticket -> {
            System.out.printf(OUTPUT_PURCHASE_TICKET_INFO.getMessage(), ticket);
            System.out.println();
        });
    }

    public void printWinningStatistics(List<String> results) {
        System.out.printf(NEWLINE.getMessage());
        System.out.println(OUTPUT_WINNING_STATISTICS_HEADER.getMessage());
        System.out.println(OUTPUT_WINNING_STATISTICS_SEPARATOR.getMessage());

        results.forEach(System.out::println);
    }

    public void printProfitRate(double profitRate) {
        DecimalFormat decimalFormat = new DecimalFormat(PROFIT_RATE_FORMAT);
        System.out.printf(OUTPUT_PROFIT_RATE.getMessage(), decimalFormat.format(profitRate));
    }
}
