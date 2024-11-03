package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentTest {

    @DisplayName("금액이 음수 일경우 예외")
    @Test
    void negativePaymentTest() {
        assertThatThrownBy(() -> Payment.from(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 나누어 떨어지지 않을 경우 예외")
    @Test
    void indivisiblePaymentTest() {
        assertThatThrownBy(() -> Payment.from(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 만큼 로또 발행 수량 확인")
    @Test
    void LottoPaymentTest() {
        Payment payment = Payment.from(5000);
        assertThat(payment.getLottoAmount()).isEqualTo(5);
    }

}