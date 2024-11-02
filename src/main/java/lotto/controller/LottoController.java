package lotto.controller;

import lotto.domain.RandomLottos;
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
        int ticket = lottoService.changeToTicket(priceInput);

        RandomLottos randomLottos = lottoService.createRandomLottos(ticket);
    }
}
