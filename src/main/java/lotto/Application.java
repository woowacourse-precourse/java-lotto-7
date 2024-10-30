package lotto;

import lotto.domain.PurchasePrice;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        final PurchasePrice purchasePrice = createPurchasePrice();
    }

    private static PurchasePrice createPurchasePrice() {
        try {
            return new PurchasePrice(InputView.inputPurchasePrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createPurchasePrice();
        }
    }
}
