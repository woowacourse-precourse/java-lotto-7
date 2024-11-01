package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        lottoService.run();
    }
}
