package controller;

import lotto.LottoList;
import lotto.PurchaseCount;
import service.LottoService;
import view.LottoView;

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

    private LottoList purchaseLottos(int purchaseCount) {
        return lottoService.generateLottos(purchaseCount);
    }

    private void displayPurchasedLottoNumbers(LottoList lottoList) {
        lottoView.printPurchasedLottoNumbersFromView(lottoList.getLottoList());
    }
}
