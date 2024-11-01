package lotto.view;

public class OutputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_TICKET_COUNT_MESSAGE = "%d개를 구매했습니다.";

    public void printPurchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchasedTicketCount(int count) {
        System.out.printf(PURCHASED_TICKET_COUNT_MESSAGE, count);
    }
}
