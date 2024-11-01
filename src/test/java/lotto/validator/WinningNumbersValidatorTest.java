package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("WinningNumbersValidator 검증 테스트")
class WinningNumbersValidatorTest {
    private final WinningNumbersValidator validator = new WinningNumbersValidator();

    @DisplayName("당첨 번호에 null이 입력되면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenInputIsNull() {
        // given
        String input = null;

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
    }

    @DisplayName("당첨 번호에 빈 문자열이 입력되면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenInputIsEmpty() {
        // given
        String input = "";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
    }

    @DisplayName("당첨 번호를 구분자로 분리한 결과에 숫자가 아닌 문자가 포함된 경우 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenWinningNumbersContainNonNumericCharacters() {
        // given
        String input = "1,2,3,4,5,a";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
    }
}