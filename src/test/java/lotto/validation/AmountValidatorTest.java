package lotto.validation;

import lotto.exception.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AmountValidatorTest{

    @DisplayName("구입 금액이 1,000원 단위로 떨어지지 않으면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {1024, 103204, 13200, 58120})
    void 구입_금액_1000원_단위_아니면_예외(int amount){
        Assertions.assertThatThrownBy(() -> AmountValidator.validateAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_AMOUNT_NOT_DIVISIBLE_BY_THOUSAND.toString());
    }

    @DisplayName("구입 금액이 1,000원 단위로 떨어지면 통과")
    @ParameterizedTest
    @ValueSource(ints = {1000, 103000, 32000, 501000})
    void 구입_금액_1000원_단위_통과(int amount){
        AmountValidator.validateAmount(amount);
    }
}
