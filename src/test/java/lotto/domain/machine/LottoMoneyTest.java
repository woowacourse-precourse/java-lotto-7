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

    @Test
    @DisplayName("로또 머니 최대 입력값을 초과할 경우, 예외가 발생한다.")
    void givenMaximumOverMoney_whenCreateLottoMoney_thenThrowException() {
        // given
        BigDecimal money = BigDecimal.valueOf(Integer.MAX_VALUE)
                .multiply(BigDecimal.valueOf(1000))
                .add(BigDecimal.ONE);

        // when & then
        assertThatThrownBy(() -> LottoMoney.from(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_MONEY_UNIT.getMessage());
    }

    @Test
    @DisplayName("로또 머니가 주어질 경우, 뽑기 횟수가 반환된다.")
    void given2000LottoMoney_whenGetDrawCount_thenGetTwoDrawCount() {
        // given
        LottoMoney lottoMoney = LottoMoney.from(BigDecimal.valueOf(2000));

        // when & then
        int result = lottoMoney.getDrawCount();

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("상금이 주어질 경우, 로또 머니로 얻은 수익률을 구한다.")
    void givenLottoMoneyAndPrizeMoney_whenGetProfitRate_thenReturnExpectedResult() {
        // given
        LottoMoney lottoMoney = LottoMoney.from(BigDecimal.valueOf(1000));
        BigDecimal prizeMoney = BigDecimal.valueOf(1234);

        // when & then
        BigDecimal result = lottoMoney.getProfitRate(prizeMoney);

        // then
        BigDecimal expectedResult = BigDecimal.valueOf(123.4);
        assertThat(result).isEqualTo(expectedResult);
    }

}