package lotto;

import lotto.ui.LottoController;

public class LottoApp {

    private final LottoController lottoController;

    public LottoApp(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public void run() {
        lottoController.purchaseAll();
    }
}
