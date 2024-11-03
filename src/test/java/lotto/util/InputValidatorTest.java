package lotto.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private InputValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InputValidator();
    }

    @DisplayName("입력 금액이 1000으로 나누어 떨어지면 테스트에 성공한다.")
    @Test
    void validatePrice_Success_Division1000() {
        // given
        String input = "3000";

        // when
        int price = validator.validatePrice(input);

        // then
        assertEquals(3000, price);
    }

    @DisplayName("입력 금액이 1000으로 나누어떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void validatePrice_Failure_Division1000() {
        // given
        String input = "2500";

        // when & then
        assertThatThrownBy( () -> validator.validatePrice(input)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("빈 문자열 입력 시 예외가 발생한다.")
    @Test
    void validatePrice_Failure_Blank() {
        // given
        String input = "   ";

        // when & then
        assertThatThrownBy( () -> validator.validatePrice(input)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("숫자가 아닌 문자열 입력 시 예외가 발생한다.")
    @Test
    void validatePrice_Failure_WhenNonNumericInput() {
        // given
        String input = "100o";

        // when & then
        assertThatThrownBy( () -> validator.validatePrice(input)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
