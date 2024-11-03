package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.exception.LottoException.EmptyInputException;
import lotto.exception.LottoException.NotAllowCharacterInputException;
import lotto.exception.LottoException.NotAllowNegativeNumberException;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 입력값이_비어있을_경우_예외_발생() {
        assertThatThrownBy(() -> InputValidator.validateEmptyInput(""))
                .isInstanceOf(EmptyInputException.class);
    }

    @Test
    void 입력값에_문자_포함하는_경우_예외_발생() {
        assertThatThrownBy(() -> InputValidator.validateIsNumeric("1000a"))
                .isInstanceOf(NotAllowCharacterInputException.class);
    }

    @Test
    void 입력값이_음수일_경우_예외_발생() {
        assertThatThrownBy(() -> InputValidator.validateNegativeNumber("-1000"))
                .isInstanceOf(NotAllowNegativeNumberException.class);
    }

    @Test
    void 입력값이_숫자일_경우_검증_성공() {
        assertDoesNotThrow(() -> InputValidator.validateIsNumeric("1000"));
    }

    @Test
    void 입력값이_양수일_경우_검증_성공() {
        assertDoesNotThrow(() -> InputValidator.validateNegativeNumber("8000"));
    }
}