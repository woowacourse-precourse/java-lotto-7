package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("빈 입력값일 때 IllegalArgumentException 발생")
    void shouldThrowException_whenInputIsEmpty() {
        InputValidator validator = new InputValidator();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                validator.validateStringTypeAmount(""));
        assertEquals("[ERROR] 입력값이 비어 있습니다. 값을 입력해 주세요.", exception.getMessage());
    }

    @Test
    @DisplayName("입력값에 공백이 포함될 때 IllegalArgumentException 발생")
    void shouldThrowException_whenInputContainsWhitespace() {
        InputValidator validator = new InputValidator();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                validator.validateStringTypeAmount("1, 000"));
        assertEquals("[ERROR] 입력값에 공백이 포함될 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("숫자와 콤마 외 다른 문자가 포함될 때 IllegalArgumentException 발생")
    void shouldThrowException_whenInputContainsInvalidCharacters() {
        InputValidator validator = new InputValidator();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                validator.validateStringTypeAmount("1,000a"));
        assertEquals("[ERROR] 입력값은 숫자와 콤마만 포함해야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("입력값이 1000원 미만일 때 IllegalArgumentException 발생")
    void shouldThrowException_whenAmountIsBelowMinimum() {
        InputValidator validator = new InputValidator();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                validator.validateIntegerTypeAmount(500));
        assertEquals("[ERROR] 1000원 이상부터 구매가 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("입력값이 10만 원 초과일 때 IllegalArgumentException 발생")
    void shouldThrowException_whenAmountExceedsLimit() {
        InputValidator validator = new InputValidator();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                validator.validateIntegerTypeAmount(100050));
        assertEquals("[ERROR] 10만 원을 초과해서 구매할 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("입력값이 1000으로 나누어 떨어지지 않을 때 IllegalArgumentException 발생")
    void shouldThrowException_whenAmountNotDivisibleByThousand() {
        InputValidator validator = new InputValidator();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                validator.validateIntegerTypeAmount(1050));
        assertEquals("[ERROR] 입력값은 1000으로 나누어 떨어져야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("정상 입력값일 때 모든 검증을 통과")
    void shouldPassValidation_whenInputIsValid() {
        InputValidator validator = new InputValidator();
        assertDoesNotThrow(() -> {
            validator.validateStringTypeAmount("10,000");
            validator.validateIntegerTypeAmount(10000);
        });
    }

}