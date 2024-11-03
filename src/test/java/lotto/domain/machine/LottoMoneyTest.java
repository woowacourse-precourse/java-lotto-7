package lotto.domain.machine;

import static lotto.exception.message.LottoMoneyExceptionMessage.INVALID_MONEY_AMOUNT;
import static lotto.exception.message.LottoMoneyExceptionMessage.INVALID_MONEY_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMoneyTest {

    @Test
    @DisplayName("천 원 단위의 금액이 아닐 경우, 예외가 발생한다.")
    void givenInvalidMoneyUnit_whenCreateLottoMoney_thenThrowException() {
        // given
        BigDecimal money = BigDecimal.valueOf(1_234);

        // when & then
        assertThatThrownBy(() -> LottoMoney.from(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_MONEY_UNIT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 999})
    @DisplayName("천원 미만의 금액일 경우, 예외가 발생한다.")
    void givenMoneyValueLessThanBase_whenCreateLottoMoney_thenThrownException(int moneyValue) {
        // given
        BigDecimal money = BigDecimal.valueOf(moneyValue);

        // when & then
        assertThatThrownBy(() -> LottoMoney.from(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_MONEY_AMOUNT.getMessage());
    }

    /*
    * 테스트 남아 있음.
    * */

}