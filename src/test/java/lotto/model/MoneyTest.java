package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.MoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("양수 금액으로 Money 인스턴스를 생성할 수 있다.")
    @Test
    void 양수금액으로_LottoMoney_생성() {
        Money money = Money.of(1000);
        assertThat(money).isNotNull();
    }

    @DisplayName("음수 금액으로 Money를 생성할 때 예외가 발생한다.")
    @Test
    void 음수금액으로_Money_생성_예외() {
        assertThatThrownBy(() -> Money.of(-1000))
                .isInstanceOf(MoneyException.class)
                .hasMessageContaining(ErrorMessages.AMOUNT_INVALID.getMessage());
    }

    @DisplayName("1000으로 나누면 올바른 값을 반환한다.")
    @Test
    void 금액을_1000으로_나누면_올바른_값이_반환된다() {
        Money money = Money.of(5000);
        int result = money.divide(1000);
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("0으로 나누면 예외가 발생한다.")
    @Test
    void 나누기_0_예외() {
        Money money = Money.of(1000);
        assertThatThrownBy(() -> money.divide(0))
                .isInstanceOf(MoneyException.class)
                .hasMessageContaining("[ERROR] 0으로 나눌 수 없습니다.");
    }

    @DisplayName("금액이 0이면 isZero()가 true를 반환한다.")
    @Test
    void 금액이_0일_경우_isZero() {
        Money money = Money.of(0);
        assertThat(money.isZero()).isTrue();
    }

    @DisplayName("금액이 0이 아닐 경우 isZero()가 false를 반환한다.")
    @Test
    void 금액이_0이_아닐_경우_isZero() {
        Money money = Money.of(1000);
        assertThat(money.isZero()).isFalse();
    }

    @DisplayName("Money를 BigDecimal로 변환할 수 있다.")
    @Test
    void LottoMoney를_BigDecimal로_변환() {
        Money money = Money.of(1000);
        BigDecimal result = money.toBigDecimal();
        assertThat(result).isEqualTo(BigDecimal.valueOf(1000));
    }

    @DisplayName("다른 Money와 더할 수 있다.")
    @Test
    void LottoMoney_더하기() {
        Money money1 = Money.of(1000);
        Money money2 = Money.of(2000);
        Money result = money1.plus(money2);
        assertThat(result).isEqualTo(Money.of(3000));
    }

    @DisplayName("null LottoMoney와 더할 때 예외가 발생한다.")
    @Test
    void null과_더할_경우_예외() {
        Money money = Money.of(1000);
        assertThatThrownBy(() -> money.plus(null))
                .isInstanceOf(MoneyException.class)
                .hasMessageContaining(ErrorMessages.OTHER_NULL.getMessage());
    }
}

