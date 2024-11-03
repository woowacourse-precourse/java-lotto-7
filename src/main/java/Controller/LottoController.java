package Controller;

import Service.LottoService;
import View.LottoView;
import lotto.PurchaseCount;

public class LottoController {
    private final LottoView lottoView;
    private final LottoService lottoService;

    public LottoController(LottoView lottoView, LottoService lottoService) {
        this.lottoView = lottoView;
        this.lottoService = lottoService;
    }

    private PurchaseCount getPurchasedLottoCount() {
        String purchaseAmount = lottoView.inputPurchaseAmount();
        return lottoService.getCount(purchaseAmount);
    }

    private String printPurchasedLottoCount(PurchaseCount purchaseCount) {
        return lottoView.printPurchasedLottoCountFromView(purchaseCount);
    }
}
