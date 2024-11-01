package lotto.domain.validator;

import static lotto.common.constant.ErrorMessages.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberFormatValidatorTest {
    private NumberFormatValidator validator;

    @BeforeEach
    void setUp() {
        validator = new NumberFormatValidator();
    }

    @Test
    @DisplayName("양의 정수는 검증을 통과한다")
    void validateShouldPassWithPositiveNumber() {
        String input = "123";

        assertThatCode(() -> validator.validate(input))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("양끝에 공백이 포함된 양의 정수도 검증을 통과한다")
    void validateShouldPassWithPositiveNumberAndSpaces() {
        String input = " 123 ";

        assertThatCode(() -> validator.validate(input))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("음수는 예외가 발생한다")
    void validateShouldThrowExceptionForNegativeNumber() {
        String input = "-123";

        assertThatThrownBy(() -> validator.validate(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(MUST_BE_WHOLE_NUMBER.toString());
    }

    @Test
    @DisplayName("0은 예외가 발생한다")
    void validateShouldThrowExceptionForZero() {
        String input = "0";

        assertThatThrownBy(() -> validator.validate(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(MUST_BE_POSITIVE_NUMBER.toString());
    }

    @Test
    @DisplayName("소수점이 있는 숫자는 예외가 발생한다")
    void validateShouldThrowExceptionForDecimal() {
        String input = "12.34";

        assertThatThrownBy(() -> validator.validate(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(MUST_BE_WHOLE_NUMBER.toString());
    }

    @Test
    @DisplayName("문자가 포함된 입력은 예외가 발생한다")
    void validateShouldThrowExceptionForAlphabets() {
        String input = "123abc";

        assertThatThrownBy(() -> validator.validate(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(MUST_BE_WHOLE_NUMBER.toString());
    }

    // validateNumber와 validatePositive 메서드에 대한 개별 테스트
    @Test
    @DisplayName("validateNumber: 올바른 숫자 형식은 통과한다")
    void validateNumberShouldPassWithValidNumber() {
        String input = "123";

        assertThatCode(() -> validator.validateNumber(input))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("validatePositive: 양수는 통과한다")
    void validatePositiveShouldPassWithPositiveNumber() {
        String input = "123";

        assertThatCode(() -> validator.validatePositive(input))
            .doesNotThrowAnyException();
    }
}
