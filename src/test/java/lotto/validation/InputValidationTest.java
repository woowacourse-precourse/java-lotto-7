package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {
    @Test
    @DisplayName("빈 문자열 오류 검출 확인하기")
    public void 빈_문자열_검증() {
        assertThatThrownBy(() -> InputValidation.isNotBlank("  "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}