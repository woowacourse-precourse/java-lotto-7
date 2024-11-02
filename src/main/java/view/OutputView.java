package view;

import domain.WinningPrice;
import java.util.Map;

public class OutputView {

    private static String TICKET_QUANTITY_MESSAGE = "%s개를 구매했습니다.";

    private OutputView() {
    }

    public static void printTicketQuantity(int ticketQuantity) {
        printBlank();
        System.out.printf(TICKET_QUANTITY_MESSAGE, ticketQuantity);
        printBlank();
    }

    public static void printResult(Map<WinningPrice, Integer> lottoResult) {
        for (WinningPrice winningPrice : lottoResult.keySet()) {
            System.out.println(winningPrice.getDescription() +" " + lottoResult.get(winningPrice));
        }
    }

    private static void printBlank() {
        System.out.println();
    }

}
