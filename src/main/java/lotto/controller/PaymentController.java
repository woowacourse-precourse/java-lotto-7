package lotto.controller;

import lotto.service.Payment;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.message.PrintMessage;

public class PaymentController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Payment payment;

    public PaymentController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.payment = payMoney();
    }

    private Payment payMoney() {
        while (true) {
            Payment newPayment = pay();
            outputView.printlnMessage(PrintMessage.LINE_SPACE);
            if (newPayment != null) {
                return newPayment;
            }
        }
    }

    private Payment pay() {
        try {
            outputView.printlnMessage(PrintMessage.INPUT_LOTTO_PURCHASE_AMOUNT);
            String money = inputView.inputUser();
            return Payment.create(money);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR");
        }
        return null;
    }

    public Payment getPayment() {
        return payment;
    }
}
