package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("숫자이외의 입력이 들어오면 오류 처리")
    @Test
    void 숫자_이외의_입력이_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateInteger("qewr"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

}