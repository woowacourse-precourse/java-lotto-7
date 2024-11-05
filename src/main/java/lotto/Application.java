package lotto;

import lotto.common.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Validator validator = new Validator();
        InputView inputView = new InputView(validator);
        LottoService lottoService = new LottoService();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(inputView, validator, lottoService, outputView);
        lottoController.drawLotto();
    }
}
