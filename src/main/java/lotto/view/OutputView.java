package lotto.view;

import static lotto.view.ViewMessage.INPUT_PURCHASE_PRICE;
import static lotto.view.ViewMessage.PRINT_TICKET_COUNT;

public class OutputView {

    private OutputView() {
    }

    public static void printInputPurchasePrice() {
        printMessage(INPUT_PURCHASE_PRICE.getMessage());
    }

    public static void printLottoTicket(int ticketCount) {
        printMessage();
        printMessage(PRINT_TICKET_COUNT.getMessage(), ticketCount);
    }

    private static void printMessage() {
        System.out.println();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printMessage(String message, Object... args) {
        System.out.println(String.format(message, args));
    }
}