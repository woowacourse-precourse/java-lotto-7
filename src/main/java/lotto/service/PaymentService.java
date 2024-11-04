package lotto.service;

import lotto.exception.BusinessException;
import lotto.exception.ErrorMessage;
import lotto.util.ConsoleInput;

public class PaymentService {

    private static final String PAYMENT_ENTER_PROMPT = "구입금액을 입력해 주세요.";
    private static final int PRICE_PER_LOTTO = 1_000;
    private static final int UNINITIALIZED = -1;

    public int buyLotto() {
        long payment = UNINITIALIZED;
        while (payment == UNINITIALIZED) {
            payment = getPayment();
        }
        return convertToLottoCnt(payment);
    }

    private long getPayment() {
        long payment;
        try {
            payment = ConsoleInput.getLongWithPrompt(PAYMENT_ENTER_PROMPT);
            validatePayment(payment);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return UNINITIALIZED;
        }
        return payment;
    }

    private void validatePayment(long payment) {
        if (payment <= 0) {
            throw new BusinessException(ErrorMessage.INVALID_PAYMENT_AMOUNT);
        }
        validateThousandUnitAmount(payment);
    }

    private void validateThousandUnitAmount(long payment) {
        if (payment % PRICE_PER_LOTTO != 0) {
            throw new BusinessException(ErrorMessage.NON_DIVISIBLE_BY_LOTTO_PRICE);
        }
    }

    private int convertToLottoCnt(long payment) {
        return (int) payment / PRICE_PER_LOTTO;
    }
}
