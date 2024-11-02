package lotto.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    @DisplayName("입력값이 null, 공백일 때 예외가 발생해야 한다")
    void shouldThrowExceptionWhenInputIsNullOrEmpty(String input) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount()
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액을 입력해 주세요."));
    }

    @ParameterizedTest
    @CsvSource({ "0", "-10", "1000.1" })
    @DisplayName("입력값이 양의 정수가 아니면 예외가 발생해야 한다")
    void shouldExceptionWhenInputIsNotPositiveNumber() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount()
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양의 정수를 입력해 주세요."));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a123", "aaa", "!@#$"})
    @DisplayName("입력값이 숫자가 아닌 문자일 때 예외가 발생해야 한다")
    void shouldThrowExceptionWhenInputIsInvalid(String input) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount()
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 금액을 입력해 주세요."));
    }

    @Test
    @DisplayName("입력값이 long의 최댓값일 때 정상적으로 금액을 반환한다")
    void shouldReturnAmountWhenInputIsLongMaxValue() {
        String input = "9223372036854775807";

        assertThat(PurchaseAmountValidator.validatePurchaseAmount(input))
                .isEqualTo(Long.MAX_VALUE);
    }

    @Test
    @DisplayName("입력값이 long의 범위를 초과할 때 예외를 발생한다")
    void shouldExceptionWhenInputExceedsLongRange() {
        String input = "9223372036854775808";

        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount(input)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력한 구입 금액이 허용된 범위를 초과했습니다."));
    }
}
