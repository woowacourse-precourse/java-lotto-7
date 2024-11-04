package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoConfig lottoConfig = new LottoConfig();
        LottoController lottoController = lottoConfig.lottoController();
        lottoController.process();
    }
}
