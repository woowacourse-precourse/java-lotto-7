package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("BonusNumberValidator 검증 테스트")
class BonusNumberValidatorTest {
    private final BonusNumberValidator validator = new BonusNumberValidator();

    @DisplayName("보너스 번호에 null이 입력되면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenInputIsNull() {
        // given
        String input = null;

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input, List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @DisplayName("보너스 번호에 빈 문자열이 입력되면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenInputIsEmpty() {
        // given
        String input = "";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input, List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @DisplayName("보너스 번호에 문자가 입력되면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenInputIsNotNumeric() {
        // given
        String input = "ab";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input, List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @DisplayName("보너스 번호에 입력된 숫자가 당첨번호와 중복될 경우 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenBonusNumberIsInWinningNumbers() {
        // given
        String input = "1";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input, List.of(1, 2, 3, 4, 5, 6, 7)));
    }
}