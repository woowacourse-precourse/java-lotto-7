package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchasePriceTest {

    @ParameterizedTest
    @DisplayName("금액 입력의 예외를 확인한다.")
    @ValueSource(strings = {"1000j", "1200"})
    void validatePriceException(String price) {
        assertThatThrownBy(() -> PurchasePrice.validatePrice(price))
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