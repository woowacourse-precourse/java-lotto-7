package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.InputValidator;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    void 구매금액이_음수이면_예외가_발생합니다() {
        InputValidator validator = new InputValidator();
        assertThatThrownBy(() -> validator.validatePurchaseAmount("-5000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값이 양수가 아닙니다.");
    }

    @Test
    void 구매금액이_숫자가_아니면_예외가_발생합니다() {
        InputValidator validator = new InputValidator();
        assertThatThrownBy(() -> validator.validatePurchaseAmount("오천원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값이 양수가 아닙니다.");
    }
}
