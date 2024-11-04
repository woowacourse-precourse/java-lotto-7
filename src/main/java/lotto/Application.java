package lotto;

import lotto.draw.DrawController;
import lotto.purchase.PurchaseController;
import lotto.result.ResultController;

public class Application {
    public static void main(String[] args) {
        PurchaseController purchaseController = new PurchaseController();
        DrawController drawController = new DrawController();
        ResultController resultController = new ResultController();
        resultController.lottoResult(purchaseController.purchaseLotto(), drawController.drawLotto());
    }
}
