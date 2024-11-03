package lotto.view;

import lotto.dto.FormattedTickets;

public class OutputView {
    private static final String PURCHASE_TOTAL_PRICE_PROMPT = "구입 금액을 입력해 주세요.";
    private static final String PURCHASED_TICKET_COUNT_MESSAGE = "%d개를 구매했습니다.";

    public void printPurchaseTotalPricePrompt() {
        System.out.println(PURCHASE_TOTAL_PRICE_PROMPT);
    }

    public void printPurchasedTicketCount(int count) {
        System.out.printf((PURCHASED_TICKET_COUNT_MESSAGE) + "%n", count);
    }

    public void printFormattedTickets(FormattedTickets formattedTickets) {
        formattedTickets.formattedTickets().forEach(System.out::println);
    }
}
