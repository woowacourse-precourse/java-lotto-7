package lotto.controller;

import static lotto.factory.ValidatorType.BONUS_NUMBER;
import static lotto.factory.ValidatorType.PRICE;
import static lotto.factory.ValidatorType.WINNING_NUMBER;

import java.util.List;
import lotto.factory.ValidatorFactory;
import lotto.model.LottoGame;
import lotto.model.LottoMachine;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    private final InputView inputView;
    private final InputConverter inputConverter;
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
        this.inputConverter = new InputConverter();
    }

    public void run() {
        int price = getInputPrice();
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber();
    }

    private int getInputPrice() {
        String inputPrice = inputView.inputPrice();
        Validator priceValidator = validatorFactory.create(PRICE);
        try {
            int price = inputConverter.convertPrice(inputPrice);
            priceValidator.validate(price);
            return price;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputPrice();
        }
    }

    private List<Integer> getWinningNumber() {
        String inputWinningNumber = inputView.inputWinningNumber();
        Validator winningNumberValidator = validatorFactory.create(WINNING_NUMBER);
        try {
            List<Integer> winningNumber = inputConverter.convertWinningNumber(inputWinningNumber);
            winningNumberValidator.validate(winningNumber);
            return winningNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    private int getBonusNumber() {
        String inputBonusNumber = inputView.inputBonusNumber();
        Validator bonusNumberValidator = validatorFactory.create(BONUS_NUMBER);
        try {
            int bonusNumber = inputConverter.convertBonusNumber(inputBonusNumber);
            bonusNumberValidator.validate(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }
}
