package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoService = new LottoService();
    }

    public void start() {
        int payment = inputView.payAmount();
        lottoService.buyLotto(payment);
    }
}
