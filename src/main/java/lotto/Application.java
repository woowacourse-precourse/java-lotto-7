package lotto;

import lotto.controller.LottoController;
import lotto.view.Output;
import lotto.view.PurchaseAmountInput;
import lotto.view.WinningNumbersInput;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new PurchaseAmountInput(),
                new WinningNumbersInput(),
                new Output()
        );
        lottoController.run();
    }
}
