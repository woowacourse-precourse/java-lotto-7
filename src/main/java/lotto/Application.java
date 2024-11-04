package lotto;

import lotto.week3.controller.LottoController;
import lotto.week3.service.LottoService;
import lotto.week3.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(lottoService);
        lottoController.run();

    }
}
