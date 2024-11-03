package lotto.purchasingLotto;

import lotto.view.Purchasing_InputView;
import lotto.view.Purchasing_OutputView;

public class PurchasingController {
    private final Purchasing_InputView inputPaymentView;
    private final PaymentValidator paymentValidator;
    private final Purchasing_OutputView outputPurchasingView;

    public PurchasingController(Purchasing_InputView inputPaymentView, PaymentValidator validator, Purchasing_OutputView outputPurchasingView) {
        this.inputPaymentView = inputPaymentView;
        this.paymentValidator = validator;
        this.outputPurchasingView = outputPurchasingView;
    }

    public int purchaseLottoTickets() {
        String inputPayment = inputPaymentView.getPayment();
        paymentValidator.validPayment(inputPayment);

        PurchasingService purchasing = PurchasingService.getPurchasingService();
        int numberOfTickets = purchasing.getNumberOfTickets(inputPayment);

        outputPurchasingView.printPurchasing(numberOfTickets);
        return numberOfTickets;
    }

}
