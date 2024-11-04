package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    public void 구매금액이_빈값일경우_예외발생() {
        //given
        String userInput = "";

        //when then
        Assertions.assertThatThrownBy(() -> InputValidator.validateNonEmptyAmount(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액을 입력해 주세요.");
    }

    @Test
    public void 구매금액에_숫자가아닌_다른_문자가_입력됬을경우_예외발생() {
        //given
        String userInput = "abc";

        //when then
        Assertions.assertThatThrownBy(() -> InputValidator.validateNumericAmount(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 숫자만 입력할 수 있습니다.");
    }

}