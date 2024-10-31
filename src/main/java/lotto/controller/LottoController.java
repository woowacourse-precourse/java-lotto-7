package lotto.controller;

import lotto.dto.response.PurchaseLottosResponse;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public PurchaseLottosResponse purchaseLottos(Integer purchaseAmount) {
        return lottoService.purchaseLottos(purchaseAmount);
    }
}
