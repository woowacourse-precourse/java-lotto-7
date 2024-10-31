package lotto.Validator;

import static lotto.error.ErrorCode.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountValidatorTest {

    @DisplayName("금액이 1000원으로 나누어 떨어지고 1000원 이상이면 검증에 성공한다.")
    @Test
    void validateSuccess() {
        int amount = 2000;

        assertThatCode(() -> AmountValidator.validateAmount(amount))
                .doesNotThrowAnyException();
    }

    @DisplayName("금액이 1000원이면 검증에 성공한다.")
    @Test
    void validateSuccess_Thousand() {
        int amount = 1000;

        assertThatCode(() -> AmountValidator.validateAmount(amount))
                .doesNotThrowAnyException();
    }

    @DisplayName("금액이 1000원으로 나누어 떨어지지 않으면 예외를 발생시킨다.")
    @Test
    void validateDivisibleByThousand() {
        int amount = 1001;

        assertThatThrownBy(() -> AmountValidator.validateAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_MULTIPLE_OF_THOUSAND.getMessage());
    }

    @DisplayName("금액이 0원 이하면 예외를 발생시킨다.")
    @Test
    void validatePositive() {
        int amount = 0;

        assertThatThrownBy(() -> AmountValidator.validateAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NEGATIVE_OR_ZERO_AMOUNT.getMessage());
    }

}