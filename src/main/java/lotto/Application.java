package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final LottoService lottoService = new LottoService();

        final LottoController lottoController = new LottoController(inputView, outputView, lottoService);

        lottoController.start();
    }
}
