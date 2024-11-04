package lotto.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyValidatorTest {

    private MoneyValidator moneyValidator;

    @BeforeEach
    void beforeEach() {
        this.moneyValidator = new MoneyValidator();
    }

    @Test
    @DisplayName("구입 금액이 1000보다 작은 경우")
    void 구입_금액이_1000보다_작은_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                moneyValidator.validateMoney(999));
    }

    @Test
    @DisplayName("구입 금액 입력이 1000으로 나누어 떨어지지 않는 경우")
    void 구입_금액_입력이_1000으로_나누어_떨어지지_않는_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                moneyValidator.validateMoney(1111));
    }

}
