package lotto;

import lotto.controller.BuyController;
import lotto.controller.ResultController;
import lotto.service.LottoMachine;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final InputValidator inputValidator = new InputValidator();
        final InputView inputView = new InputView(inputValidator);
        final LottoMachine lottoMachine = new LottoMachine();
        final OutputView outputView = new OutputView();
        final BuyController buyController = new BuyController(inputView, lottoMachine, outputView);
        buyController.buy();
        final ResultController resultController = new ResultController(inputView, lottoMachine, outputView);
        resultController.result();
    }
}
