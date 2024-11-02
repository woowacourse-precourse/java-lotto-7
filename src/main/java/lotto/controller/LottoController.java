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

    public void setWinLottoNumbers(List<Integer> numbers) {
        lottoService.setWinLottoNumbers(numbers);
    }

    public void setWinLottoBonusNumber(Integer number) {
        lottoService.setWinLottoBonusNumber(number);
    }

    public getLottoResultResponse getLottoResult() {
        return lottoService.getLottoResult();
    }
}
