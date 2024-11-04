package lotto.service;

import lotto.exception.BusinessException;
import lotto.util.ConsoleInput;

public class PaymentService {

    private static final int PRICE_PER_LOTTO = 1_000;

    public int buyLotto() {
        long payment = -1;
        while (payment < 0) {
            payment = getPayment();
        }
        return convertToLottoCnt(payment);
    }

    private long getPayment() {
        long payment;
        try {
            payment = ConsoleInput.getLongWithPrompt("구입금액을 입력해 주세요.");
            validatePayment(payment);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return payment;
    }

    private void validatePayment(long payment) {
        if (payment <= 0) {
            throw new BusinessException("구입 금액으로 0 또는 음수는 입력할 수 없습니다.");
        }
        validateThousandUnitAmount(payment);
    }

    private void validateThousandUnitAmount(long payment) {
        if (payment % 1000 != 0) {
            throw new BusinessException("구입 금액은 1,000 단위로 입력해주세요.");
        }
    }

    private int convertToLottoCnt(long payment) {
        return (int) payment / PRICE_PER_LOTTO;
    }
}
