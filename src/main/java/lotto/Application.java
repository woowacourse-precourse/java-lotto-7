package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoService;
import lotto.model.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoServiceImpl();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(lottoService, inputView, outputView);
        lottoController.run();
    }
}
