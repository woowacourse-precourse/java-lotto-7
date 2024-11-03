package lotto.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyInputValidatorTest {

    @Test
    @DisplayName("구입 금액 입력에 숫자가 아닌 문자가 포함된 경우")
    void 구입_금액_입력에_숫자가_아닌_문자가_포함된_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                MoneyInputValidator.validateMoneyInput("1a00"));
    }

    @Test
    @DisplayName("구입 금액이 1000보다 작은 경우")
    void 구입_금액이_1000보다_작은_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                MoneyInputValidator.validateMoneyInput("999"));
    }

    @Test
    @DisplayName("구입 금액 입력이 1000으로 나누어 떨어지지 않는 경우")
    void 구입_금액_입력이_1000으로_나누어_떨어지지_않는_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                MoneyInputValidator.validateMoneyInput("1111"));
    }
}
