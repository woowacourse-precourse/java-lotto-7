package lotto.util.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class NumericValidatorTest {
    @Test
    void 숫자_문자열_검증_성공() {
        assertDoesNotThrow(() -> NumericValidator.validate("123"));
    }

    @Test
    void 숫자가_아닌_문자열_검증_실패() {
        assertThatThrownBy(() -> NumericValidator.validate("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_문자열_검증_실패() {
        assertThatThrownBy(() -> NumericValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백이_포함된_문자열_검증_실패() {
        assertThatThrownBy(() -> NumericValidator.validate("12 34"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
