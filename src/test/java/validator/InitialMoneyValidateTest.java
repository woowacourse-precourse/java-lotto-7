package validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InitialMoneyValidateTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("validateNumber 문자열 입력 테스트")
    @Test
    void validateNumber_문자열_입력_테스트() {
        assertThatThrownBy(() -> Validator.validateNumber("aespa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("validateNumber 실수 입력 테스트")
    @Test
    void validateNumber_실수_입력_테스트() {
        assertThatThrownBy(() -> Validator.validateNumber("1.2f"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("validateNumber 정상 검증 테스트")
    @Test
    void validateNumber_정상_검증_테스트() {
        assertThatCode(() -> Validator.validateNumber("123"))
                .doesNotThrowAnyException();
    }

    @DisplayName("validatePositiveNumber 0 입력 테스트")
    @Test
    void validatePositiveNumber_0_입력_테스트() {
        assertThatThrownBy(() -> Validator.validatePositiveNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }


    @DisplayName("validatePositiveNumber 음수 입력 테스트")
    @Test
    void validatePositiveNumber_음수_입력_테스트() {
        assertThatThrownBy(() -> Validator.validatePositiveNumber("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("validatePositiveNumber 정상 검증 테스트")
    @Test
    void validatePositiveNumber_정상_검증_테스트() {
        assertThatCode(() -> Validator.validatePositiveNumber("3000"))
                .doesNotThrowAnyException();
    }

    @DisplayName("validateNonCharge 1000단위가 아닌 입력 테스트")
    @Test
    void validateNonCharge_1000단위가_아닌_입력_테스트() {
        assertThatThrownBy(() -> Validator.validateNonCharge(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("validateNonCharge 정상 검증 테스트")
    @Test
    void validateNonCharge_정상_검증_테스트() {
        assertThatCode(() -> Validator.validateNonCharge(3000))
                .doesNotThrowAnyException();
    }
}
