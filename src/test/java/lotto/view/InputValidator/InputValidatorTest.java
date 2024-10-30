package lotto.view.InputValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.view.validator.InputValidator;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    void 입력된_문자열이_공백일_때_예외_발생_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateNull(""));
        assertEquals("[ERROR] 공백은 입력할 수 없습니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateNull("  \n"));
        assertEquals("[ERROR] 공백은 입력할 수 없습니다.", exception.getMessage());
    }

    @Test
    void 숫자가_아닌_값이_입력되면_예외_발생_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateInteger("two hundred"));
        assertEquals("[ERROR] 숫자만 입력 가능합니다.", exception.getMessage());
    }
}