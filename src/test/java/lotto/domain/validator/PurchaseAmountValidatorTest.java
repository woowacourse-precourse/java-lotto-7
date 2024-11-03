package lotto.domain.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @CsvSource({"asdf", "-1", "0", "a1b2", "1*2"})
    @DisplayName("구매 금액으로 양수가 아닌 입력이 들어오는 경우")
    void whenOverIntegerRangeThenThrowException(String invalidMoney) {
        //when then
        Assertions.assertThatThrownBy(() -> PurchaseAmountValidator.validate(invalidMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 양수만 입력이 가능합니다.");
    }

    @Test
    @DisplayName("구매 금액이 integer 범위를 벗어나는 경우")
    void whenOverIntegerRangeThenThrowException() {
        //given
        String invalidMoney = "2147483649";

        //when then
        Assertions.assertThatThrownBy(() -> PurchaseAmountValidator.validate(invalidMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 2,147,483,647보다 클 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource({"100", "10", "9", "1100", "12340"})
    @DisplayName("구매 금액이 1000원 단위로 들어오지 않는 경우")
    void whenIsNotThousandUnitThenThrowException(String invalidMoney) {
        //when then
        Assertions.assertThatThrownBy(() -> PurchaseAmountValidator.validate(invalidMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 1000원 단위로 입력이 가능합니다.");
    }
}
