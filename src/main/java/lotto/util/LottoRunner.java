package lotto.util;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoRunner {

    public static void run() {
        LottoView lottoView = new LottoView();
        lottoView.runLotto(new LottoController(new LottoService()));
    }
}