package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoContainer lottoContainer = new LottoContainer();
        LottoController lottoController = lottoContainer.lottoController();
        lottoController.process();
    }
}
