package lotto.controller;

import static lotto.factory.ValidatorType.BONUS_NUMBER;
import static lotto.factory.ValidatorType.PRICE;
import static lotto.factory.ValidatorType.WINNING_NUMBER;

import lotto.factory.ValidatorFactory;
import lotto.model.LottoGame;
import lotto.model.LottoMachine;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final ValidatorFactory validatorFactory;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;
    private final LottoGame lottoGame;

    public LottoController(InputView inputView, ValidatorFactory validatorFactory, LottoMachine lottoMachine,
                           LottoGame lottoGame, OutputView outputView) {
        this.inputView = inputView;
        this.validatorFactory = validatorFactory;
        this.lottoMachine = lottoMachine;
        this.lottoGame = lottoGame;
        this.outputView = outputView;
    }

    public void run() {
        int price = inputView.getPriceInput();
        Validator priceValidator = validatorFactory.create(PRICE);
        priceValidator.validate(price);

        String winningNumber = inputView.getWinningNumberInput();
        Validator winningNumbersValidator = validatorFactory.create(WINNING_NUMBER);
        winningNumbersValidator.validate(winningNumber);

        int bonusNumber = inputView.getBonusNumberInput();
        Validator bonusNumberValidator = validatorFactory.create(BONUS_NUMBER);
        bonusNumberValidator.validate(bonusNumber);
    }
}
