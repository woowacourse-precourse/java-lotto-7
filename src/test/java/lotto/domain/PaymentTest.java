package lotto.domain;

import lotto.exception.PaymentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest {
    Payment payment;

    @Test
    @DisplayName("금액을 입력하면 Payment 를 생성한다.")
    void CreatePaymentWhenInputMoney() {
        int money = 1000;
        int lottoCount = money / 1000;

        payment = Payment.of(money);

        Assertions.assertEquals(Payment.class, payment.getClass());
        Assertions.assertEquals(payment.getLottoCount(), lottoCount);
    }

    @Test
    @DisplayName("0이나 음수를 입력하면 예외를 발생한다.")
    void ThrowExceptionWhenInputZeroOrNegative() {
        int zero = 0;
        int negative = -1;

        PaymentException zeroException = Assertions.assertThrows(PaymentException.class, () ->
                Payment.of(zero)
        );

        PaymentException negativeException = Assertions.assertThrows(PaymentException.class, () ->
                Payment.of(negative)
        );

        Assertions.assertEquals(zeroException.getMessage(), negativeException.getMessage());
    }

    @Test
    @DisplayName("로또 가격 단위로 숫자를 입력하지 않으면 예외를 발생한다.")
    void ThrowExceptionWhenNotDivisibleByLottoPrice() {
        int notDivisibleMoney = 999;

        Assertions.assertThrows(PaymentException.class, () ->
            Payment.of(notDivisibleMoney)
        );
    }
}