package lotto.Controller;

public class LottoController {
    PurchaseController purchaseController;

    public LottoController() {
        purchaseController = new PurchaseController();
    }

    public void start() {
        int LottoCount = purchaseController.purchase();
    }
}
