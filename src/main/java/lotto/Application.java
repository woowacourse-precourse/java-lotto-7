package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoGameController;
import lotto.util.NumberConverter;
import lotto.util.StringParser;
import lotto.validator.NumberValidator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        NumberConverter numberConverter = new NumberConverter();
        StringParser stringParser = new StringParser();
        NumberValidator numberValidator = new NumberValidator();

        InputController inputController = new InputController(inputView, numberConverter, stringParser, numberValidator);

        LottoGameController lottoGameController = new LottoGameController(inputController);
        lottoGameController.run();

    }
}
