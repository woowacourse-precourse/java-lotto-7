package lotto.controller;

import lotto.factory.PaymentFactory;
import lotto.factory.WalletGeneratorFactory;
import lotto.service.Payment;
import lotto.service.generator.WalletGenerator;
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
            WalletGenerator wallet = WalletGeneratorFactory.create(money);
            return PaymentFactory.create(wallet.getWallet());
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
        }
        return null;
    }
}
