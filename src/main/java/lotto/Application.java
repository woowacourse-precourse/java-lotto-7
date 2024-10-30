package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class Application {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        LottoView lottoView = new LottoView();
        LottoController lottoController = new LottoController(lottoService, lottoView);

        lottoController.run();
    }

}
