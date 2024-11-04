package lotto.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constant.LottoValues.MONEY_MIN_LIMIT;
import static lotto.constant.LottoValues.PRICE;
import static lotto.message.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class MoneyInputHandlerTest {

    private final MoneyInputHandler moneyInputHandler = new MoneyInputHandler();

    @DisplayName("구입 금액을 성공적으로 받는 경우")
    @Test
    void moneySuccessTest() {
        // given
        String inputNum = "5238000";

        // when
        long rawMoney = moneyInputHandler.convertToInt(inputNum);
        long lottoCount = moneyInputHandler.validateMoney(rawMoney);

        // then
        assertThat(lottoCount).isEqualTo(5238L);
    }

    @DisplayName("구입 금액은 0도 가능하다")
    @Test
    void moneyBoundaryValueSuccessTest() {
        // given
        String zero = "0";

        // when
        long rawMoney = moneyInputHandler.convertToInt(zero);
        long lottoCount = moneyInputHandler.validateMoney(rawMoney);

        // then
        assertThat(lottoCount).isEqualTo(0);
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "23489b"})
    void NonIntegerMoneyExceptionTest(String nonInteger) {
        // when & then
        assertThatCode(() -> moneyInputHandler.convertToInt(nonInteger))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NON_INTEGER_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("구입 금액이 음수면 예외가 발생한다")
    @Test
    void NegativeMoneyExceptionTest() {
        // given
        long negativeLong = -1L;

        // when & then
        assertThatCode(() -> moneyInputHandler.validateMoney(negativeLong))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NEGATIVE_PURCHASE_AMOUNT.formatCost(MONEY_MIN_LIMIT.value()));
    }


    @DisplayName("구입 금액은 1000으로 나누어 떨어지지 않으면 예외가 발생한다")
    @Test
    void IndivisibleMoneyExceptionTest() {
        // given
        long inputNum = 123654687;

        // when & then
        assertThatCode(() -> moneyInputHandler.validateMoney(inputNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PURCHASE_AMOUNT_UNIT.formatCost(PRICE.value()));
    }

}
