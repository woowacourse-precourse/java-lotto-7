package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.generator.RandomGenerator;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumbersValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView(
                new PurchaseAmountValidator(),
                new WinningNumbersValidator(),
                new BonusNumberValidator()
        );
        OutputView outputView = new OutputView();
        LottoMachine lottoMachine = new LottoMachine(new RandomGenerator());
        LottoController lottoController = new LottoController(inputView, outputView, lottoMachine);
        lottoController.run();
    }
}
