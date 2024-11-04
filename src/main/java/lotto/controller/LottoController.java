package lotto.controller;

import lotto.Service.LottoService;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService){
        this.lottoService = lottoService;
    }

    public void start(){
        int purchaseAmount = lottoService.inputPurchaseAmount();
    }
}
