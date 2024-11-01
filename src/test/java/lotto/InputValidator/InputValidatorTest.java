package lotto.InputValidator;

import lotto.exception.InputErrorMessage;
import lotto.util.InputValidator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {


    @Test
    void 입력금액이_1000원_단위일때_통과한다() {
        String validAmount = "1000";
        InputValidator.validateAmount(validAmount);
    }

    @Test
    void 입력금액이_1000원_단위가_아닐때_예외발생() {
        String inValidAmount = "2500";
        assertThatThrownBy(() -> InputValidator.validateAmount(validAmount))
            .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
    }
}
