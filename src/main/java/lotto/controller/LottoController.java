package lotto.controller;

import lotto.domain.Lottos;
import lotto.dto.LottoResult;
import lotto.dto.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        PurchaseAmount purchaseAmount = getValidLottoPurchaseAmount();
        Lottos lottos = new Lottos(purchaseAmount);
        showLottoNumbers(purchaseAmount, lottos);
    }

    public PurchaseAmount getValidLottoPurchaseAmount() {
        try {
            PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.inputLottoPurchaseAmount());
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidLottoPurchaseAmount();
        }
    }

    public void showLottoNumbers(PurchaseAmount purchaseAmount, Lottos lottos) {
        LottoResult lottoResult = new LottoResult(
                purchaseAmount.getPurchaseAmount(),
                lottos.displayLottos());
        OutputView.printLottoResult(lottoResult);
    }
}
