package lotto;

import lotto.controller.LottoController;
import lotto.model.ResultCalculator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumberValidator;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new PurchaseAmountValidator(),
                new WinningNumberValidator(),
                new ResultCalculator()
        );
        lottoController.start();
    }
}
