package lotto;

import lotto.domain.PurchaseAmount;
import lotto.io.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        PurchaseAmount purchaseAmount = inputView.inputPurchaseAmount();

    }
}
