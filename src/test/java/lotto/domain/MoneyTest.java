package lotto.domain;

import static lotto.utils.ErrorMessage.BIG_MONEY;
import static lotto.utils.ErrorMessage.INVALID_MONEY_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @Test
    @DisplayName("동일 금액 테스트")
    void test1() {
        Money money1 = new Money("1000");
        Money money2 = new Money("1000");

        assertThat(money1).isEqualTo(money2);
    }

    @ParameterizedTest
    @DisplayName("예외: null 과 blank")
    @NullAndEmptySource
    void test2(String money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_MONEY_INPUT.getMessage());
    }

    @Test
    @DisplayName("예외: 음수 입력 1000 단위")
    void test3() {
        assertThatThrownBy(() -> new Money("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_MONEY_INPUT.getMessage());
    }

    @Test
    @DisplayName("최대값 테스트")
    void test5() {
        Long maxValue = Long.MAX_VALUE / 1000 * 1000;

        String maxMoney = String.valueOf(maxValue);
        Money money = new Money(maxMoney);

        assertThat(money.toString()).hasToString(maxMoney);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1000.5", "1500", "999", "1001"})
    @DisplayName("예외: 0, 소수, 천원 단위 x")
    void test6(String money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_MONEY_INPUT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("lotto try 테스트")
    @ValueSource(longs = {1000, 2000, 5000, 10000000, 10000})
    void test7(Long longValue) {
        Long expectedCnt = longValue / 1000;
        Money money = new Money(String.valueOf(longValue));

        Long cnt = 0L;
        while (money.lottoTry()) {
            cnt++;
        }

        assertThat(cnt).isEqualTo(expectedCnt);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void test8() {
        // given
        Money money = Money.create("1000");
        BigDecimal bigDecimal = sumPercentage("1000");

        // when
        String result = money.calculateProfitRate(bigDecimal);

        // then
        assertThat(result).isEqualTo("100.0");
    }

    @Test
    @DisplayName("최대 테스트 : Long Max Value")
    void test9() {
        // given
        String maxProfit = String.valueOf(Long.MAX_VALUE);
        Money money = Money.create("1000");

        BigDecimal bigDecimal = sumPercentage(maxProfit);

        // when
        String result = money.calculateProfitRate(bigDecimal);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("Long 보다 큰 입력은 에러를 반환한다.")
    void test10() {
        assertThatThrownBy(() -> new Money("10000000000000000000000000000000000000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BIG_MONEY.getMessage());
    }

    @ParameterizedTest
    @DisplayName("돈에 소수점은 허용하지 않는다.")
    @ValueSource(strings = {"1000.00", "2000.0"})
    void test11(String input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_MONEY_INPUT.getMessage());
    }

    private BigDecimal sumPercentage(String sum) {
        BigDecimal bigDecimal1 = new BigDecimal(sum);
        BigDecimal bigDecimal2 = new BigDecimal("100");
        return bigDecimal1.multiply(bigDecimal2);
    }
}
