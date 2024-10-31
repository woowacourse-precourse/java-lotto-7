package lotto;

import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final PurchasePrice purchasePrice = createPurchasePrice();
        final Lottos lottos = new Lottos(purchasePrice);
        OutputView.printPurchasedLottos(lottos);
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
