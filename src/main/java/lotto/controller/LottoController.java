package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.LottoStaticsOutputHandler;
import lotto.view.NumberOfLottoOutputHandler;
import lotto.view.PurchaseAmountInputHandler;

import java.util.List;

public class LottoController {
    LottoService lottoService = new LottoService();
    NumberOfLottoOutputHandler numberOfLottoOutputHandler = new NumberOfLottoOutputHandler(lottoService);
    LottoStaticsOutputHandler lottoStaticsOutputHandler = new LottoStaticsOutputHandler(lottoService);

    public void run() {
        String purchaseAmountInput = PurchaseAmountInputHandler.promptPurchaseAmount();
        PurchaseAmountInputHandler.validatePurchaseAmount(purchaseAmountInput);
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        numberOfLottoOutputHandler.displayNumberOfLottos(purchaseAmount);
        List<Lotto> lottos = lottoService.issueLottos(purchaseAmount);

    }
}
