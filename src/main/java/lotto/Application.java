package lotto;

import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final PurchasePrice purchasePrice = createPurchasePrice();
        final Lottos lottos = new Lottos(purchasePrice);
        OutputView.printPurchasedLottos(lottos);

        final WinningNumber winningNumber = createWinningNumber();
    }

    private static PurchasePrice createPurchasePrice() {
        try {
            return new PurchasePrice(InputView.inputPurchasePrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createPurchasePrice();
        }
    }

    private static WinningNumber createWinningNumber() {
        try {
            return new WinningNumber(InputView.inputWinningNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningNumber();
        }
    }
}
