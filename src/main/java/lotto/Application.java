package lotto;

import lotto.controller.LottoController;
import lotto.ui.error.ErrorView;
import lotto.model.service.LottoService;
import lotto.ui.input.InputParser;
import lotto.ui.input.InputView;
import lotto.ui.output.OutputView;
import lotto.util.UIExecutor;

public class Application {
    public static void main(String[] args) {
        ErrorView errorView = new ErrorView();
        UIExecutor uiExecutor = new UIExecutor(errorView);
        InputView inputView = new InputView(new InputParser());
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();

        LottoController lottoController = new LottoController(uiExecutor, inputView, outputView, lottoService);

        lottoController.run();
    }
}
