package lotto.controller;

import lotto.service.Payment;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.message.PrintMessage;

public class PaymentController {

    private final InputView inputView;
    private final OutputView outputView;

    public PaymentController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Payment pay() {
        while (true) {
            Payment newPayment = payMoney();
            outputView.printlnMessage(PrintMessage.LINE_SPACE);
            if (newPayment != null) {
                return newPayment;
            }
        }
    }

    private Payment payMoney() {
        try {
            outputView.printlnMessage(PrintMessage.INPUT_LOTTO_PURCHASE_AMOUNT);
            String money = inputView.inputUser();
            return Payment.create(money);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR");
        }
        return null;
    }
}
