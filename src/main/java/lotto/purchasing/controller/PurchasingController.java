package lotto.purchasing.controller;

import lotto.dto.NumberOfTicketsDto;
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

    public void purchaseLottoTickets() {
        receivePayment();
        int numberOfTickets = payment.getNumberOfTickets();
        purchasingOutputView.printPurchasing(numberOfTickets);
        NumberOfTicketsDto.set(numberOfTickets);
    }

    private void receivePayment() {
        try {
            String inputPayment = purchasingInputView.getPayment();
            payment = new Payment(inputPayment);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            purchasingInputView.setPaymentNull();
            receivePayment();
        }

    }

}
