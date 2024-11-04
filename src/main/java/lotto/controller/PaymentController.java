package lotto.controller;

import lotto.domain.Payment;
import lotto.exception.ParserException;
import lotto.exception.PaymentException;
import lotto.utils.Parser;
import lotto.view.InputReader;
import lotto.view.OutputView;

public class PaymentController {

    public PaymentController() {
    }

    public Payment processPayment() {
        while (true) {
            try {
                int money = getPaymentAmount();
                return Payment.of(money);
            } catch (PaymentException | ParserException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getPaymentAmount() {
        OutputView.printPaymentMessage();
        String moneyInput = InputReader.readLine();
        return Parser.parseStringToInt(moneyInput);
    }
}
