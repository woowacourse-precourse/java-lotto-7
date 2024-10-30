package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;

    public LottoController(LottoService lottoService, InputView inputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
    }

    public void run() {
        getPrice();
    }

    public void getPrice() {
        String price = inputView.readPrice();
    }
}
