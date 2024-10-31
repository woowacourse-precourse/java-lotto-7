package lotto.domain;

import static lotto.utils.ErrorMessage.INVALID_MONEY_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        // 최대값을 1000원 단위로 분할하자
        Long maxValue = Long.MAX_VALUE / 1000 * 1000;

        String maxMoney = String.valueOf(maxValue);
        Money money = new Money(maxMoney);

        assertThat(money.toString()).hasToString(maxMoney);

    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1000.5", "1500"})
    @DisplayName("예외: 0, 소수, 천원 단위 x")
    void test6(String money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_MONEY_INPUT.getMessage());
    }

    @Test
    @DisplayName("lotto try 테스트")
    void test7() {
        Long longValue = 10000L;
        Long expectedCnt = longValue / 1000;
        Money money = new Money(String.valueOf(longValue));

        Long cnt = 0L;
        while (money.lottoTry()) {
            cnt++;
        }

        assertThat(cnt).isEqualTo(expectedCnt);
    }


}
