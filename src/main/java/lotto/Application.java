package lotto;

import lotto.controller.LottoController;
import lotto.model.Issuer;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoPurchaseValidator;
import lotto.validator.WinningNumberValidator;
import lotto.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoPurchaseValidator(),
                new WinningNumberValidator(), new BonusNumberValidator(),
                new ConsoleView(), new Issuer());
        lottoController.run();
    }
}
