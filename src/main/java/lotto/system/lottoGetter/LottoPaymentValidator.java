package lotto.system.lottoGetter;

import static lotto.system.utils.constants.LottoConstants.TICKET_PRICE;
import static lotto.system.utils.constants.LottoErrorMessages.INSUFFICIENT_PAYMENT;
import static lotto.system.utils.constants.LottoErrorMessages.INVALID_MULTIPLE_OF_TICKET_PRICE;

public class LottoPaymentValidator { // 로또 구매 금액을 검증하는 객체

    public static void validate(int totalPayment) {
        validateSufficientPayment(totalPayment);
        validateMultipleOfTicketPrice(totalPayment);
    }

    private static void validateMultipleOfTicketPrice(int totalPayment) {
        if (totalPayment % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_MULTIPLE_OF_TICKET_PRICE.getMessage());
        }
    }

    private static void validateSufficientPayment(int totalPayment) {
        if (totalPayment < TICKET_PRICE) {
            throw new IllegalArgumentException(INSUFFICIENT_PAYMENT.getMessage());
        }
    }
}
