package lotto.controller;

import lotto.service.PurchasingService;
import lotto.validator.PaymentValidator;
import lotto.view.InputPaymentView;

public class PurchasingController {
    private final InputPaymentView inputPaymentView;
    private final PaymentValidator paymentValidator;

    public PurchasingController(InputPaymentView inputPaymentView, PaymentValidator validator) {
        this.inputPaymentView = inputPaymentView;
        this.paymentValidator = validator;
    }

    public void purchaseLottoTickets() {
        String inputPayment = inputPaymentView.getPayment();
        paymentValidator.validPayment(inputPayment);
        PurchasingService purchasing = new PurchasingService();
        purchasing.purchaseTickets(inputPayment);
    }

}
