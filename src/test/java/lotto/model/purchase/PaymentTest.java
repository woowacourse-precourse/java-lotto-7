package lotto.model.purchase;

import static lotto.constant.ErrorMessage.INVALID_PAYMENT_POSITIVE_INTEGER;
import static lotto.constant.ErrorMessage.INVALID_PAYMENT_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PaymentTest {
    @Test
    void 구매금액_설정_테스트() {
        // given
        String paymentInput = "1000";
        // when
        Payment payment = new Payment(paymentInput);
        // then
        assertThat(payment.getPayment()).isEqualTo(1000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "123abc", "-1"})
    void 양수가아닌입력_예외테스트(String paymentInput) {
        assertThatThrownBy(() -> new Payment(paymentInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PAYMENT_POSITIVE_INTEGER.getFormatMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    void 로또가격으로_나누어지지않는입력_예외테스트(String paymentInput) {
        assertThatThrownBy(() -> new Payment(paymentInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PAYMENT_UNIT.getFormatMessage());
    }
}
