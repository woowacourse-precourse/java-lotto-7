package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoService;
import lotto.model.StringParser;
import lotto.model.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Validation validation = new Validation();
        InputView inputView = new InputView();
        LottoService lottoService = new LottoService();
        OutputView outputView = new OutputView(lottoService);
        StringParser stringParser = new StringParser(validation);
        LottoController lottoController = new LottoController(inputView, outputView, stringParser, lottoService);

        lottoController.Game();
    }
}
