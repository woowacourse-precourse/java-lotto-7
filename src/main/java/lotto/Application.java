package lotto;

import lotto.controller.LottoController;
import lotto.model.Issuer;
import lotto.parser.InputParser;
import lotto.validator.LottoPurchaseValidator;
import lotto.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoPurchaseValidator(), new InputParser(), new ConsoleView(), new Issuer());
        lottoController.run();
    }
}
