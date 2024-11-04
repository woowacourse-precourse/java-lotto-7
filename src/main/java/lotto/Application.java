package lotto;

import lotto.controller.LottoController;
import lotto.util.RandomNumbersGenerator;
import lotto.validator.CommonInputValidator;
import lotto.validator.NumberInputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new CommonInputValidator(), new NumberInputValidator());
        OutputView outputView = new OutputView();

        LottoController lottoController = new LottoController(inputView, outputView, new RandomNumbersGenerator());
        lottoController.run();
    }
}
