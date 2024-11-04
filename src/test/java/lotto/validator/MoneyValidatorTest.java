package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.exception.LottoException;
import org.junit.jupiter.api.Test;

public class MoneyValidatorTest {

    @Test
    void 유효하지_않은_구입금액_예외(){
        assertThrows(LottoException.class, () -> MoneyValidator.validate("1500"));
        assertThrows(LottoException.class, () -> MoneyValidator.validate("900"));
        assertThrows(LottoException.class, () -> MoneyValidator.validate("abc"));
    }

    @Test
    void 유효한_구입금액_검증(){
        MoneyValidator.validate("2000");
        MoneyValidator.validate("5000");
        MoneyValidator.validate("10000");
    }
}
