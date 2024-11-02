package lotto.purchase;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.purchase.PaymentExtractor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentExtractorTest {

    @DisplayName("로또 구입 금액에 null이 입력되면 예외가 발생한다.")
    @Test
    void shouldThrowIllegalArgumentExceptionWhenInputNullPayment() {
        assertThatThrownBy(() -> new PaymentExtractor().validateInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] null은 입력할 수 없습니다.");
    }

    @DisplayName("로또 구입 금액에 빈 문자열이 입력되면 예외가 발생한다.")
    @Test
    void shouldThrowIllegalArgumentExceptionWhenInputEmptyPayment() {
        assertThatThrownBy(() -> new PaymentExtractor().validateInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자열과 공백은 입력할 수 없습니다.");
    }

    @DisplayName("로또 구입 금액에 공백이 입력되면 예외가 발생한다.")
    @Test
    void shouldThrowIllegalArgumentExceptionWhenInputBlankPayment() {
        assertThatThrownBy(() -> new PaymentExtractor().validateInput(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자열과 공백은 입력할 수 없습니다.");
    }

    @DisplayName("로또 구입 금액에 숫자가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void shouldThrowIllegalArgumentExceptionWhenInputNotNumberPayment() {
        assertThatThrownBy(() -> new PaymentExtractor().validateInput("100-0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 숫자만 가능합니다.");
    }

    @DisplayName("로또 구입 금액이 1000원 단위로 입력되지 않으면 예외가 발생한다.")
    @Test
    void shouldThrowIllegalArgumentExceptionWhenInputRemainderPayment() {
        assertThatThrownBy(() -> new PaymentExtractor().validateInput("1200120"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
    }

    @DisplayName("로또 구입 금액이 0원이면 예외가 발생한다.")
    @Test
    void shouldThrowIllegalArgumentExceptionWhenInputZeroPayment() {
        assertThatThrownBy(() -> new PaymentExtractor().validateInput("0000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 0원이 될 수 없습니다.");
    }

    @DisplayName("문자열에서 로또 구입 금액(정수)을 추출한다.")
    @Test
    void shouldExtractIntegerPaymentWhenGiveRawPaymentString() {
        // give
        String rawPayment = "1000";
        Integer expectedPayment = 1000;
        PaymentExtractor paymentExtractor = new PaymentExtractor();

        // when
        Integer actualPayment = paymentExtractor.extract(rawPayment);

        // then
        Assertions.assertThat(actualPayment).isEqualTo(expectedPayment);
    }
}
