package lotto.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.exception.LottoException;
import org.junit.jupiter.api.Test;

public class MoneyValidatorTest {

    @Test
    void 유효하지_않은_구입금액_예외() {
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("1500"));
        assertThat(exception1.getMessage()).contains("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("abc"));
        assertThat(exception2.getMessage()).contains("[ERROR] 로또 구입 금액은 숫자로 입력해야 합니다.");
    }

    @Test
    void 유효한_구입금액_검증() {
        MoneyValidator.validate("2000");
        MoneyValidator.validate("5000");
        MoneyValidator.validate("10000");
    }
}
