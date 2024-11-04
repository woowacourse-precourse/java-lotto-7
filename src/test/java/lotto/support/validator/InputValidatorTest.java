package lotto.support.validator;

import static lotto.support.utils.CustomExceptionAssertions.assertCustomIllegalArgumentException;

import java.util.Collections;
import lotto.exception.argument.validator.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("입력값 검증 테스트")
class InputValidatorTest {

    @Nested
    @DisplayName("null or blank 검증 테스트")
    class nullOrBlank_검증_테스트 {

        @Test
        @DisplayName("null이면 예외가 발생한다.")
        void 실패_검증_null() {
            // Given

            // When & Then
            assertCustomIllegalArgumentException(() -> InputValidator.validateNotNullOrBlank(null, "입력값"))
                    .isExactlyInstanceOf(InvalidInputException.class)
                    .hasMessageContaining("입력값은(는) null일 수 없습니다.");
        }

        @Test
        @DisplayName("비어있으면 예외가 발생한다.")
        void 실패_검증_empty() {
            // Given

            // When & Then
            assertCustomIllegalArgumentException(() -> InputValidator.validateNotNullOrBlank("", "입력값"))
                    .isExactlyInstanceOf(InvalidInputException.class)
                    .hasMessageContaining("입력값은(는) 빈 문자열이거나 공백일 수 없습니다.");
        }

        @Test
        @DisplayName("공백이면 예외가 발생한다.")
        void 실패_검증_공백() {
            // Given

            // When & Then
            assertCustomIllegalArgumentException(() -> InputValidator.validateNotNullOrBlank(" ", "입력값"))
                    .isExactlyInstanceOf(InvalidInputException.class)
                    .hasMessageContaining("입력값은(는) 빈 문자열이거나 공백일 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("null or empty 검증 테스트")
    class nullOrEmpty_검증_테스트 {

        @Test
        @DisplayName("null이면 예외가 발생한다.")
        void 실패_검증_null() {
            // Given

            // When & Then
            assertCustomIllegalArgumentException(() -> InputValidator.validateNotNullOrEmpty(null, "입력값"))
                    .isExactlyInstanceOf(InvalidInputException.class)
                    .hasMessageContaining("입력값은(는) null일 수 없습니다.");
        }

        @Test
        @DisplayName("비어있으면 예외가 발생한다.")
        void 실패_검증_empty() {
            // Given

            // When & Then
            assertCustomIllegalArgumentException(
                    () -> InputValidator.validateNotNullOrEmpty(Collections.emptyList(), "입력값"))
                    .isExactlyInstanceOf(InvalidInputException.class)
                    .hasMessageContaining("입력값은(는) 빈 문자열일 수 없습니다.");
        }
    }
}
