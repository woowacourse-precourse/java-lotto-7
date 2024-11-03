package lotto.validation;

import static org.assertj.core.api.Assertions.*;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.Test;

public class MoneyValidatorTest {
    @Test
    void 정상적인_구입_금액_검사() {
        Integer money = 4000;

        assertThatCode(() -> MoneyValidator.validateMoney(money)).doesNotThrowAnyException();
    }

    @Test
    void 비정상적인_구입_금액_검사() {
        Integer money = 4431;

        assertThatThrownBy(() -> MoneyValidator.validateMoney(money))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_MONEY_UNIT.getMessage());
    }

    @Test
    void 자연수_아닌_숫자_입력() {
        Integer money = -1;

        assertThatThrownBy(() -> MoneyValidator.validateMoney(money))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.NOT_NATURAL_NUMBER.getMessage());
    }
}
