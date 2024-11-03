package lotto;

import lotto.domain.PositiveNumber;
import lotto.ui.LottoController;

public class LottoApp {

    private final LottoController lottoController;

    public LottoApp(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public void run() {
        PositiveNumber purchasePrice = lottoController.purchaseAll();

    }
}
