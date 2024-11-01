package lotto.controller;

import lotto.service.PurchasingService;
import lotto.view.InputPaymentView;

public class PurchasingController {
    private final InputPaymentView inputPaymentView;

    public PurchasingController(InputPaymentView inputPaymentView) {
        this.inputPaymentView = inputPaymentView;
    }

    public void purchaseLottoTickets() {
        String inputPayment = inputPaymentView.getPayment();
        int payment = Integer.parseInt(inputPayment);
        PurchasingService purchasingService = new PurchasingService();
        purchasingService.purchaseTickets(payment);
    }

}
