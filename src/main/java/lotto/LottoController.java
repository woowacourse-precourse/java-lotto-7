package lotto;

import lotto.model.Purchase;
import lotto.view.PurchaseView;

public class LottoController {
    public void purchaseLotto() {
        PurchaseView purchaseView = new PurchaseView();
        String payment = purchaseView.getPayment();
        Purchase purchase = new Purchase(payment);
        purchaseView.displayPurchaseResult(purchase.getLottoCount(), purchase.getPurchasedLottoTickets());
    }
}
