package lotto.controller;

import lotto.service.LottoService;
import lotto.view.LottoInputView;

public class LottoController {

    private final LottoService lottoService;
    private final LottoInputView inputView;

    public LottoController(LottoService lottoService, LottoInputView inputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
    }

    public void run() {
        String priceInput = inputView.getPriceInput();
        int price = lottoService.changeToTicket(priceInput);

    }
}
