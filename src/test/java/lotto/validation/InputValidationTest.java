package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {
    @Test
    @DisplayName("빈 문자열 오류 검출 확인하기")
    public void 빈_문자열_검증() {
        assertThatThrownBy(() -> InputValidation.isNotBlank("  "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 변환 불가할때 오류 확인하기")
    public void 숫자_변환_검증() {
        assertThatThrownBy(() -> InputValidation.parseValidateNumber("1w3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}