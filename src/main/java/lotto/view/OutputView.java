package lotto.view;

import java.util.List;

public class OutputView {

    private static final String PURCHASED_QUANTITY_MESSAGE = "\n%d개를 구매했습니다.\n";

    public void printPurchasedQuantity(int purchasedQuantity) {
        System.out.printf(PURCHASED_QUANTITY_MESSAGE, purchasedQuantity);
    }

    public void printLottoTickets(List<List<Integer>> lottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer> lottoTicket : lottoTickets) {
            stringBuilder.append(lottoTicket.toString())
                            .append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }
}
