package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.purchasing.model.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PaymentTest {

    @DisplayName("1000원 단위가 아닌 금액 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "8300", "4500"})
    void 천원단위가_아닌_금액(String inputPayment) {
        assertThatThrownBy(() -> new Payment(inputPayment))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("실수나 소수인 금액 입력")
    @ParameterizedTest
    @ValueSource(strings = {"-100", "4000.0", "43000.63"})
    void 실수나_소수인_금액(String inputPayment) {
        assertThatThrownBy(() -> new Payment(inputPayment))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0원 혹은 공백인 금액 입력")
    @ParameterizedTest
    @ValueSource(strings = {"0", "0.0", "", "  ", "\n"})
    void 영원_혹은_공백인_금액(String inputPayment) {
        assertThatThrownBy(() -> new Payment(inputPayment))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
