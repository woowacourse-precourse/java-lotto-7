package lotto.controller;

import lotto.service.Payment;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.PrintMessage;

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
        outputView.printlnMessage(PrintMessage.INPUT_LOTTO_PURCHASE_AMOUNT);
        String money = inputView.inputUser();
        outputView.printlnMessage(PrintMessage.LINE_SPACE);
        return Payment.create(money);
    }

    public Payment getPayment() {
        return payment;
    }
}
