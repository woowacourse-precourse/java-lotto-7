package lotto;

import lotto.draw.DrawController;
import lotto.draw.model.Draw;
import lotto.purchase.PurchaseController;
import lotto.purchase.model.Purchase;
import lotto.result.ResultController;

public class ApplicationController {
    private final PurchaseController purchaseController = new PurchaseController();
    private final DrawController drawController = new DrawController();
    private final ResultController resultController = new ResultController();

    public void run() {
        Purchase purchase = purchaseController.purchaseLotto();
        Draw draw = drawController.drawLotto();
        resultController.lottoResult(purchase, draw);
    }
}
