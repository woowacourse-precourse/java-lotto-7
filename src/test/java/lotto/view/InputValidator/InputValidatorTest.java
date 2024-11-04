package lotto.view.InputValidator;

import org.junit.jupiter.api.Test;

import lotto.view.validator.InputValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    @Test
    void 입력된_문자열이_공백일_때_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateNull(""));
        assertEquals("[ERROR] 공백은 입력할 수 없습니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateNull("  \n"));
        assertEquals("[ERROR] 공백은 입력할 수 없습니다.", exception.getMessage());
    }

    @Test
    void 숫자가_아닌_값이_입력되면_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateInteger("two hundred"));
        assertEquals("[ERROR] 숫자만 입력 가능합니다.", exception.getMessage());
    }

    @Test
    void 당첨_번호에_쉼표가_없으면_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateContainsComma("12"));
        assertEquals("[ERROR] 숫자 사이에 쉼표(,)를 사용해서 입력해주세요.", exception.getMessage());
    }

    @Test
    void 당첨_번호_처음이나_마지막에_쉼표가_있으면_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateCommaFormat("1,2,4,8,6,5,"));
        assertEquals("[ERROR] 숫자 사이에 쉼표(,)를 사용해서 입력해주세요.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateCommaFormat(",1,2,4,8,6,5,"));
        assertEquals("[ERROR] 숫자 사이에 쉼표(,)를 사용해서 입력해주세요.", exception.getMessage());
    }

    @Test
    void 로또_구입_금액이_양수가_아니면_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validatePositiveNumber("-10000"));
        assertEquals("[ERROR] 양수 정수만 입력해주세요.", exception.getMessage());
    }
}