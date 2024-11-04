package lotto.view;

import static lotto.system.utils.constants.ViewMessages.BONUS_NUMBER;
import static lotto.system.utils.constants.ViewMessages.LOTTO_TICKET_QUANTITY;
import static lotto.system.utils.constants.ViewMessages.PURCHASE_AMOUNT;
import static lotto.system.utils.constants.ViewMessages.WINNING_NUMBER;

import java.util.List;
import lotto.system.unit.LottoTicket;

public class OutputView {

    private OutputView() {
        throw new IllegalStateException("OutputView is utility class");
    }

    public static void displayPurchasePrompt() {
        printMessage(PURCHASE_AMOUNT.getMessage());
    }

    public static void displayTicketQuantity(int quantity) {
        printMessage(LOTTO_TICKET_QUANTITY.getMessage(quantity));
    }

    public static void displayLottoTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(ticket -> printMessage(ticket.toString()));
        printNewLine();
    }

    public static void displayWinningNumberPrompt() {
        printMessage(WINNING_NUMBER.getMessage());
    }

    public static void displayBonusNumberPrompt() {
        printMessage(BONUS_NUMBER.getMessage());
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