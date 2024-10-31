package lotto;

import lotto.common.Validator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Validator validator = new Validator();
        LottoController lottoController = new LottoController(inputView, validator);
        lottoController.getUserInput();
    }
}
