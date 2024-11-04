package lotto.console;

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

    @Test
    void 쉼표로_구분된_숫자_리스트는_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> inputValidator.validateNumbersByComma("1,2,3"));
    }

    @Test
    void 쉼표로_구분된_숫자_리스트가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateNumbersByComma("1,2,3;q;w;e"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 쉼표로 구분해서 숫자를 입력해주세요");
    }

}
