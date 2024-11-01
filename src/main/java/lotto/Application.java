package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        LottoService lottoService = new LottoService();

        LottoController lottoController = new LottoController(inputView, lottoService);
        lottoController.run();
    }
}
