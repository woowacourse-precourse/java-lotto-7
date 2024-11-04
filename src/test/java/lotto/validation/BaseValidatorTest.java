package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseValidatorTest {

    @DisplayName("null 입력 시 IllegalArgumentException 발생")
    @Test
    void null_입력_예외() {
        // given
        String input = null;
        // when, then
        Assertions.assertThatThrownBy(()->BaseValidator.validateNull(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 문자열 입력 시 IllegalArgumentException 발생")
    @Test
    void 빈_문자열_예외() {
        // given
        String input = "";
        // when, then
        Assertions.assertThatThrownBy(()->BaseValidator.validateEmpty(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 문자열이 입력되면 예외가 발생하지 않습니다")
    @Test
    void 정상_입력_통과(){
        // given
        String input = "input";
        // when, then
        BaseValidator.validateNull(input);
        BaseValidator.validateEmpty(input);
    }
}