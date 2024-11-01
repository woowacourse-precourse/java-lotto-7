package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasePriceTest {

    @Test
    @DisplayName("정수가 아닌 금액이 입력되었을 때 예외가 발생한다.")
    void validateIntegerExceptionPrice() {
        assertThatThrownBy(() -> PurchasePrice.validatePrice("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1000으로 나누어떨어지지 않는 금액이 입력되었을 때 예외가 발생한다.")
    void validateDivideExceptionPrice() {
        assertThatThrownBy(() -> PurchasePrice.validatePrice("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 입력을 받았을 때 동작을 확인한다.")
    void validatePrice() {
        //when
        PurchasePrice purchasePrice = PurchasePrice.validatePrice("1000");

        //then
        assertThat(purchasePrice.value()).isEqualTo(1000);
    }
}