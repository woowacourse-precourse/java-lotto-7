package lotto.purchasing.controller;

import lotto.purchasing.model.Payment;
import lotto.purchasing.view.*;

public class PurchasingController {
    private final PurchasingInputView purchasingInputView;
    private final PurchasingOutputView purchasingOutputView;
    private Payment payment;

    public PurchasingController() {
        this.purchasingInputView = new PurchasingInputView();
        this.purchasingOutputView = new PurchasingOutputView();
    }

    public int purchaseLottoTickets() {
        receivePayment();
        int numberOfTickets = payment.getNumberOfTickets();
        purchasingOutputView.printPurchasing(numberOfTickets);
        return numberOfTickets;
    }

    private void receivePayment() {
        try {
            String inputPayment = purchasingInputView.getPayment();
            payment = new Payment(inputPayment);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchasingInputView.setPaymentNull();
            receivePayment();
        }

    }

}
