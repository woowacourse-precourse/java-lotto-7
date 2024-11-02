package lotto.controller;

import lotto.service.PurchasingService;
import lotto.validator.PaymentValidator;
import lotto.view.InputPaymentView;

public class PurchasingController {
    private final InputPaymentView inputPaymentView;
    private final PaymentValidator validator;

    public PurchasingController(InputPaymentView inputPaymentView, PaymentValidator validator) {
        this.inputPaymentView = inputPaymentView;
        this.validator = validator;
    }

    public void purchaseLottoTickets() {
        String inputPayment = inputPaymentView.getPayment();
        int payment = validator.validPayment(inputPayment);
        PurchasingService purchasingService = new PurchasingService();
        purchasingService.purchaseTickets(payment);
    }

}
