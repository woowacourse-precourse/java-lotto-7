package lotto.purchasing;

import lotto.purchasing.view.InputPaymentView;

public class PurchasingController {
    private final InputPaymentView inputPaymentView;
    private final PaymentValidator paymentValidator;

    public PurchasingController(InputPaymentView inputPaymentView, PaymentValidator validator) {
        this.inputPaymentView = inputPaymentView;
        this.paymentValidator = validator;
    }

    public int purchaseLottoTickets() {
        String inputPayment = inputPaymentView.getPayment();
        paymentValidator.validPayment(inputPayment);
        PurchasingService purchasing = new PurchasingService();
         return purchasing.purchaseTickets(inputPayment);
    }

}
