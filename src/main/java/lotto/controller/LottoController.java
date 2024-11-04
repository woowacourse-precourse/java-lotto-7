package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void run() {
        lottoService.inputPrice();
        lottoService.initCustomer();
        lottoService.purchaseLottos();
        lottoService.showLottos();
        lottoService.setWinningNumbers();
        lottoService.setBonusNumber();
        lottoService.initWinningLotto();
        lottoService.result();
        lottoService.calculate();
    }
}
