package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static lotto.domain.Money.LOTTO_PRICE;
import static lotto.exception.ExceptionCode.MONEY_TOO_SMALL;
import static lotto.exception.ExceptionCode.REMAINDER_EXISTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("구매 금액이 로또 금액보다 작으면 예외가 발생한다.")
    @Test
    void TooSmallException() {
        assertThatThrownBy(() -> new Money(new BigInteger("120")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MONEY_TOO_SMALL.message());
    }

    @DisplayName("구매 금액이 로또 금액으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void RemainderExistedException() {
        assertThatThrownBy(() -> new Money(new BigInteger("1100")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(REMAINDER_EXISTED.message());
    }

    @DisplayName("구매 금액 생성하면 구입 가능한 로또의 개수를 반환한다.")
    @Test
    void getNumberOfLotto() {
        BigInteger value = new BigInteger("10000");
        Money money = new Money(value);
        assertThat(money.numberOfLotto()).isEqualTo(value.divide(LOTTO_PRICE));
    }

}