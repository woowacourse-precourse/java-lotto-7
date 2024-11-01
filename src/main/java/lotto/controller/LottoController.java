package lotto.controller;

import lotto.dto.response.PurchaseLottosResponse;
import lotto.dto.response.getLottoResultResponse;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public PurchaseLottosResponse purchaseLottos(Long purchaseAmount) {
        return lottoService.purchaseLottos(purchaseAmount);
    }

    public getLottoResultResponse getLottoResult(List<Integer> winLottoNumbers, Integer bonusNumber) {
        return lottoService.getLottoResult(winLottoNumbers, bonusNumber);
    }
}
