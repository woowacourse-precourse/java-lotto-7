package lotto;

import lotto.dto.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printPurchaseAmountMessage();

        InputView inputView = new InputView();
        PurchaseAmount purchaseAmount = inputView.readPurchaseAmount();

        int amount = purchaseAmount.getValue();
        System.out.println("입력된 금액: " + amount);
    }
}
