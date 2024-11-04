package lotto;

import lotto.controller.LottoController;
import lotto.service.CalculateService;
import lotto.service.LottoDrawService;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        LottoDrawService lottoDrawService = new LottoDrawService();
        CalculateService calculateService = new CalculateService();

        LottoController lottoController = new LottoController(lottoService,lottoDrawService,calculateService);
        lottoController.run();
    }
}
