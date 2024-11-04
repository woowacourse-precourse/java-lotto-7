package lotto.view;

import lotto.view.message.OutputMessage;
import lotto.vo.Ticket;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.message.OutputMessage.*;
public class OutputView {
    public static void printTicketAmount(int ticketAmount) {
        System.out.println();
        formatAndPrint(PURCHASE_AMOUNT, ticketAmount);
    }

    public static void printTickets(List<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            System.out.print("[");
            System.out.print(ticket.getTicket()
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println("]");
        }
    }

    public static void printResult(List<Integer> winningCount, double profitRate) {
        System.out.println();
        System.out.println(WINNING_STATISTICS.getMessage());
        System.out.println(SEPARATOR.getMessage());
        formatAndPrint(THREE_MATCH, winningCount.get(4));
        formatAndPrint(FOUR_MATCH, winningCount.get(3));
        formatAndPrint(FIVE_MATCH, winningCount.get(2));
        formatAndPrint(FIVE_BONUS_MATCH, winningCount.get(1));
        formatAndPrint(SIX_MATCH, winningCount.get(0));
        formatAndPrint(TOTAL_RETURN, profitRate);
    }

    private static void formatAndPrint(OutputMessage message, int count) {
        System.out.println(String.format(message.getMessage(), count));
    }

    private static void formatAndPrint(OutputMessage message, double profitRate) {
        System.out.println(String.format(message.getMessage(), profitRate));
    }
}
