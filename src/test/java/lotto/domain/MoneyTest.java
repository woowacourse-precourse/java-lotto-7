package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static lotto.exception.ExceptionCode.MONEY_TOO_SMALL;
import static lotto.exception.ExceptionCode.REMAINDER_EXISTED;
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

}