package lotto;

import lotto.controller.LottoController;
import lotto.model.service.LottoService;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoView(), new LottoService());
        lottoController.run();
    }
}
