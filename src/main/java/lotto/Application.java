package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoHandler;

public class Application {
    public static void main(String[] args) {

        final LottoHandler lottoHandler = new LottoHandler();

        final LottoController lottoController = new LottoController(lottoHandler);

        lottoController.start();
    }
}
