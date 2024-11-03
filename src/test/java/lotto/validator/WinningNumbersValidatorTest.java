package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.message.ErrorMessage;
import org.junit.jupiter.api.Test;

class WinningNumbersValidatorTest {
    @Test
    void 당첨_번호_빈_입력인_경우_예외_처리() {
        String input = "";

        assertThatThrownBy(() -> WinningNumbersValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.IS_EMPTY.getMessage());
    }

    @Test
    void 당첨_번호_쉼표가_포함되지_않은_경우_입력_예외_처리() {
        String input = "123456";

        assertThatThrownBy(() -> WinningNumbersValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NO_COMMA.getMessage());
    }

    @Test
    void 당첨_번호_숫자가_아닌_문자가_포함된_입력_예외_처리() {
        String input = "1,2,3,4,5,six";

        assertThatThrownBy(() -> WinningNumbersValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMERIC.getMessage());
    }
}