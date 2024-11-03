package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    void 숫자라면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> inputValidator.validateNumeric("1000"));
    }

    @Test
    void 숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateNumeric("123qwe"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 숫자를 입력해주세요.");
    }

}
