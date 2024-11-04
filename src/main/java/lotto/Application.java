package lotto;

import lotto.controller.LottoController;
import lotto.factory.ValidatorFactory;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        ValidatorFactory validatorFactory = new ValidatorFactory();
        OutputView outputView = new OutputView();
        LottoMachine lottoMachine = new LottoMachine();
        LottoController lottoController = new LottoController(inputView, validatorFactory, lottoMachine, outputView);

        lottoController.run();
    }
}
