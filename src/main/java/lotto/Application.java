package lotto;

import lotto.controller.ApplicationController;
import lotto.service.Extractor;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        LottoService lottoService = new LottoService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        ApplicationController app = new ApplicationController(extractor, lottoService, inputView, outputView);
        app.run();
    }
}
