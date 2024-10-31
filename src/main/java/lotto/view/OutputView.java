package lotto.view;

public class OutputView {

    private static final String PURCHASE_TICKET_MESSAGE = "%d개를 구매했습니다.";

    public void printTicketNumber(int number) {
        System.out.println();
        System.out.println(String.format(PURCHASE_TICKET_MESSAGE, number));
    }
}
