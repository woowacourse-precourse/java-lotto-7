package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoInputValidatorTest {
    @DisplayName("문자열이 입력되면 예외가 발생한다.")
    @Test
    void 문자열이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoInputValidator("2r"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ExceptionMessage.INVALID_INPUT_FORMAT.getErrorMessage());
    }

    @DisplayName("입력값이 비어 있으면 예외가 발생한다.")
    @Test
    void 입력값이_비어_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoInputValidator(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EMPTY_INPUT.getErrorMessage());
    }

}