package lotto;

import lotto.config.LottoGameAppConfig;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoGameAppConfig.getLottoController();
        lottoController.start();
    }
}
