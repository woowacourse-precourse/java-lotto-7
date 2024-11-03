package lotto.controller;

import lotto.message.PrintMessage;
import lotto.service.Payment;
import lotto.service.generator.WalletGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

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
            WalletGenerator wallet = WalletGenerator.create(money);
            return Payment.create(wallet.getWallet());
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
        }
        return null;
    }
}
