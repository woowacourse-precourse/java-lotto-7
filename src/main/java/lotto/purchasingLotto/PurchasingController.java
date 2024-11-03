package lotto.purchasingLotto;

import lotto.view.InputPaymentView;
import lotto.view.OutputPurchasingView;

public class PurchasingController {
    private final InputPaymentView inputPaymentView;
    private final PaymentValidator paymentValidator;
    private final OutputPurchasingView outputPurchasingView;

    public PurchasingController(InputPaymentView inputPaymentView, PaymentValidator validator, OutputPurchasingView outputPurchasingView) {
        this.inputPaymentView = inputPaymentView;
        this.paymentValidator = validator;
        this.outputPurchasingView = outputPurchasingView;
    }

    public int purchaseLottoTickets() {
        String inputPayment = inputPaymentView.getPayment();
        paymentValidator.validPayment(inputPayment);
        PurchasingService purchasing = PurchasingService.getPurchasingService();
        int payment = purchasing.purchaseTickets(inputPayment);
        outputPurchasingView.printPurchasing(payment);
         return payment;
    }

}
