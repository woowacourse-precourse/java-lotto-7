package lotto.view;

import lotto.view.message.OutputMessage;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.message.OutputMessage.*;
public class OutputView {
    public static void printTicketAmount(int ticketAmount) {
        System.lineSeparator();
        // TODO: ticketAmount 자료형 객체로?
        formatAndPrint(PURCHASE_AMOUNT, ticketAmount);
    }

    public static void printTicketNumbers(List<List<Integer>> tickets) {
        // TODO: wticketAmount 자료형 객체로?
        for (List<Integer> ticket : tickets) {
            System.out.print("[");
            System.out.print(ticket.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println("]");
            // TODO: 모든 리터럴 상수화? 흠..
        }
    }

    public static void printResult(List<Integer> winningCount, double profitRate) {
        // TODO: winningCount, profitRate 자료형 객체로?
        System.out.println(WINNING_STATISTICS);
        System.out.println(SEPARATOR);
        formatAndPrint(THREE_MATCHES, winningCount.get(0));
        formatAndPrint(FOUR_MATCHES, winningCount.get(1));
        formatAndPrint(FIVE_MATCHES, winningCount.get(2));
        formatAndPrint(FIVE_BONUS_MATCHES, winningCount.get(3));
        formatAndPrint(SIX_MATCHES, winningCount.get(4));
        formatAndPrint(TOTAL_RETURN, profitRate);
    }

    private static void formatAndPrint(OutputMessage message, int count) {
        System.out.println(String.format(message.getMessage(), count));
    }

    // TODO: 오버로딩 굳이??
    private static void formatAndPrint(OutputMessage message, double profitRate) {
        System.out.println(String.format(message.getMessage(), profitRate));
    }
}
