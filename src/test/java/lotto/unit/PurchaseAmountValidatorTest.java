package lotto.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validator.PurchaseAmountValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountValidatorTest {

    private PurchaseAmountValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new PurchaseAmountValidator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    @DisplayName("입력값이 null, 공백일 때 예외가 발생해야 한다")
    void shouldThrowExceptionWhenInputIsNullOrEmpty(String input) {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액을 입력해 주세요.");
    }

    @ParameterizedTest
    @CsvSource({ "0", "-10" })
    @DisplayName("입력값이 양의 정수가 아니면 예외가 발생해야 한다")
    void shouldExceptionWhenInputIsNotPositiveNumber(String input) {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양의 정수를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a123", "aaa", "!@#$", "1000.1"})
    @DisplayName("입력값이 Long 타입이 아닐 때 예외가 발생해야 한다")
    void shouldThrowExceptionWhenInputIsInvalid(String input) {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 금액을 입력해 주세요.");
    }

    @Test
    @DisplayName("1000원 단위로 나누어 떨어지지 않을 때 예외를 발생해야 한다")
    void shouldExceptionWhenInputIsNotDivide1000() {
        String input = "1001";

        assertThatThrownBy(() -> validator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위로 입력해 주세요.");
    }

    @Test
    @DisplayName("입력값이 long의 최댓값일 때 정상적으로 금액을 반환한다")
    void shouldReturnAmountWhenInputIsLongMaxValue() {
        String input = "9223372036854775000";

        assertThat(validator.validatePurchaseAmount(input))
                .isEqualTo(9223372036854775000L);
    }

    @Test
    @DisplayName("입력값이 long의 범위를 초과할 때 예외를 발생한다")
    void shouldExceptionWhenInputExceedsLongRange() {
        String input = "9223372036854775808";

        assertThatThrownBy(() -> validator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 금액을 입력해 주세요.");
    }
}
