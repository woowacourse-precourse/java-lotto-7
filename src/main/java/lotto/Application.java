package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.OutputView.ENTER_PURCHASE_PRICE;

public class Application {

    public static void main(String[] args) {

        OutputView.printMessage(ENTER_PURCHASE_PRICE);
        String purchasePrice = InputView.readLine();
    }
}
