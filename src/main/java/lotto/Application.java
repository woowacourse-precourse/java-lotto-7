package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.validator.BonusNumberValidator;
import lotto.validator.MoneyValidator;
import lotto.validator.WinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();
        MoneyValidator moneyValidator = new MoneyValidator();
        WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

        LottoController lottoController = new LottoController(
                inputView,
                outputView,
                lottoService,
                moneyValidator,
                winningNumberValidator,
                bonusNumberValidator
        );

        lottoController.startLottoGame();
    }
}
