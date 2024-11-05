package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorUtilTest {

    @Test
    @DisplayName("입력값이 숫자가 아닐 경우 예외가 발생해야 한다.")
    void 숫자_형식_검증() {
        assertThatThrownBy(() -> ValidatorUtil.validateNumericInput("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 값은 숫자로만 이루어져 있어야 합니다.");
    }

    @Test
    @DisplayName("입력값이 숫자 형식일 경우 정상 동작")
    void 정상_숫자_형식() {
        ValidatorUtil.validateNumericInput("123"); // 예외 발생하지 않으면 테스트 통과
    }
}