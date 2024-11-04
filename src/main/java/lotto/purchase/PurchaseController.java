package lotto.purchase;

import lotto.purchase.model.Purchase;

public class PurchaseController {
    private final PurchaseView purchaseView = new PurchaseView();

    public Purchase purchaseLotto() {
        while (true) {
            try {
                String paymentInput = purchaseView.readPayment();
                Purchase purchase = new Purchase(paymentInput);
                purchaseView.displayPurchaseResult(purchase.calculateLottoCount(), purchase.getPurchasedLottoTickets());
                return purchase;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage() + "\n");
            }
        }
    }
}
