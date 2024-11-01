package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        String inputLottoPrice = inputView.getLottoPriceByUser();
        lottoService.createAutoLottosByLottoPrice(inputLottoPrice);
    }



}
