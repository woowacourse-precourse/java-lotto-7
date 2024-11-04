package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("금액을 입력하지 않으면 예외가 발생한다.")
    @Test
    void emptyMoneyTest() {
        assertThatThrownBy(() -> new Money(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 유효하지 않으면 예외가 발생한다.")
    @Test
    void nullMoneyTest() {
        assertThatThrownBy(() -> new Money(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 음수면 예외가 발생한다.")
    @Test
    void negativeMoneyTest() {
        assertThatThrownBy(() -> new Money("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 0이면 예외가 발생한다.")
    @Test
    void zeroMoneyTest() {
        assertThatThrownBy(() -> new Money("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}