package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("로또 구입 금액 유효성 검사 - 성공 테스트")
    void validateLottoPurchaseAmount_success() {
        // given
        Integer lottoPurchaseAmount = 2000;

        // when & then
        assertThatCode(() -> Validator.validateLottoPurchaseAmount(lottoPurchaseAmount))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 구입 금액 유효성 검사: 배수 아님 - 예외 테스트")
    void validateLottoPurchaseAmount_notMultiple() {
        // given
        Integer lottoPurchaseAmount = 2500;

        // when & then
        assertThatThrownBy(() -> Validator.validateLottoPurchaseAmount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}