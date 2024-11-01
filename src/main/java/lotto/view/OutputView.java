package lotto.view;

import static lotto.view.ViewMessage.INPUT_PURCHASE_PRICE;
import static lotto.view.ViewMessage.PRINT_TICKET_COUNT;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    private OutputView() {
    }

    public static void printInputPurchasePrice() {
        printMessage(INPUT_PURCHASE_PRICE.getMessage());
    }

    public static void printLottoTicketCounts(int ticketCount) {
        printMessage();
        printMessage(PRINT_TICKET_COUNT.getMessage(), ticketCount);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printMessage(lotto.toString());
        }
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