package lotto.view;

import java.util.List;
import lotto.system.unit.LottoTicket;
import lotto.system.utils.constants.ViewMessages;

public class OutputView {

    private OutputView() {
        throw new IllegalStateException("OutputView is utility class");
    }

    public static void displayPurchasePrompt() {
        printMessage(ViewMessages.PURCHASE_AMOUNT.getMessage());
    }

    public static void displayTicketQuantity(int quantity) {
        printMessage(ViewMessages.LOTTO_TICKET_QUANTITY.getMessage(quantity));
    }

    public static void displayLottoTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(ticket -> printMessage(ticket.toString()));
        printNewLine();
    }

    public static void displayWinningNumberPrompt() {
        printMessage(ViewMessages.WINNING_NUMBER.getMessage());
    }

    public static void displayBonusNumberPrompt() {
        printMessage(ViewMessages.BONUS_NUMBER.getMessage());
    }

    public static void displayResult(String result) {
        printMessageWithNewLine(result);
    }
    private static void printMessageWithNewLine(String message) {
        printMessage(message);
        printNewLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printNewLine() {
        System.out.println();
    }
}