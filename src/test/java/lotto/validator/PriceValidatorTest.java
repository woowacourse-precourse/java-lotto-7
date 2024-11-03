package lotto.validator;

import lotto.model.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PriceValidatorTest {

    @Test
    @DisplayName("가격은 0보다 큰 1000의 배수여야 한다.")
    void validatePrice() {
        int price = 3000;
        Assertions.assertThatNoException().isThrownBy(() -> PriceValidator.validatePrice(price));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3002", "-1"})
    @DisplayName("가격은 0보다 큰 1000의 배수가 아닌 정수는 예외가 발생한다")
    void invalidatePriceRange(int price) {
        Assertions.assertThatThrownBy(() -> PriceValidator.validatePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_PRICE.getMessage());
    }
}