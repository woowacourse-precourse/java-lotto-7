package lotto;

import lotto.controller.LottoController;
import lotto.exception.ValidationValues;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        LottoController lottoController = new LottoController(lottoService);
        lottoController.startLotto();

    }
}
