package lotto.view;

import lotto.dto.PurchaseOverview;
import lotto.dto.Quantity;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";

    public void printPurchaseOverview(Quantity quantity,
                                      PurchaseOverview overview) {
        System.out.println(String.format(PURCHASE_MESSAGE, quantity.getQuantity()));
        System.out.println(overview.getOverview());
    }
}
