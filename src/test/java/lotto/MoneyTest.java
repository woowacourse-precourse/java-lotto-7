package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validator.InputValidator.MoneyValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    private final MoneyValidator validator = new MoneyValidator();
    private static final String ERROR_MESSAGE = MoneyValidator.ERROR_MESSAGE;

    @Test
    @DisplayName("유효한 금액 입력")
    void testValidInput() {
        assertThat(validator.validate("1000")).isEqualTo(1000);
    }

    @ParameterizedTest
    @CsvSource({
            "abc, 유효한 숫자를 입력해야 합니다.",
            "2147483648, 입력이 정수 범위를 초과합니다.",
            "-2147483649, 입력이 정수 범위를 초과합니다."
    })
    @DisplayName("문자 입력 또는 범위를 초과하는 경우")
    void testInvalidFormatOrOutOfRange(String input, String errorMessage) {
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " " + errorMessage);
    }

    @Test
    @DisplayName("공백 입력 시 예외 발생")
    void testEmptyInput() {
        assertThatThrownBy(() -> validator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 유효한 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("공백 문자열 입력 시 예외 발생")
    void testWhitespaceInput() {
        assertThatThrownBy(() -> validator.validate(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 유효한 숫자를 입력해야 합니다.");
    }


    @Test
    @DisplayName("음수 금액 입력 시 예외 발생")
    void testNegativeAmount() {
        assertThatThrownBy(() -> validator.validate("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 금액은 음수가 될 수 없습니다.");
    }

    @Test
    @DisplayName("0원 입력 시 예외 발생")
    void testZeroAmount() {
        assertThatThrownBy(() -> validator.validate("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 입력 금액이 0원입니다.");
    }

    @Test
    @DisplayName("1,000원 단위가 아닌 금액 입력 시 예외 발생")
    void testNotThousandUnit() {
        assertThatThrownBy(() -> validator.validate("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 금액은 1,000원 단위여야 합니다.");
    }
}
