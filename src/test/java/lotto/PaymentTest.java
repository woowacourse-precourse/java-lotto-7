package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Constants.ERROR_HEADER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentTest {

    @DisplayName("로또 구입 금액은 1,000원 단위로 입력받는다.")
    @Test
    void 로또_구입_금액을_천원_단위로_입력받는다() {
        String input = "1000";

        Payment payment = Payment.from(input);

        assertEquals(1000, payment.get());
    }

    @DisplayName("로또 구입 금액이 null일 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_null일_경우_예외가_발생한다() {
        assertPaymentThrows(null);
    }

    @DisplayName("로또 구입 금액에 문자가 입력될 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액에_문자가_입력될_경우_예외가_발생한다() {
        assertPaymentThrows("3000.14");
        assertPaymentThrows("300 0");
        assertPaymentThrows(" ");
        assertPaymentThrows("*");
        assertPaymentThrows("-1");
        assertPaymentThrows("500o");
    }

    @DisplayName("로또 구입 금액에 아무것도 입력되지 않을 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액에_아무것도_입력되지_않을_경우_예외가_발생한다() {
        assertPaymentThrows("");
    }

    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_천원으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        assertPaymentThrows("0");
        assertPaymentThrows("1500");
    }

    @DisplayName("로또 구입 금액이 100,000원을 초과할 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_십만원을_초과할_경우_예외가_발생한다() {
        assertPaymentThrows("101000");
    }

    void assertPaymentThrows(String input) {
        assertThatThrownBy(() -> Payment.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_HEADER);
    }
}
