package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private final LottoController lottoController;

    public Application(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoController lottoController = new LottoController(lottoService, inputView, outputView);
        Application application = new Application(lottoController);

        application.lottoController.run();
    }
}
