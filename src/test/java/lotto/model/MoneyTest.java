package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.enums.ExceptionMessage.INVALID_MONEY_UNIT;
import static lotto.enums.ExceptionMessage.ZERO_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MoneyTest {

    @DisplayName("1000원 단위가 아니면 예외 발생")
    @Test
    void invalidUnitTest() {
        assertThatThrownBy(() -> new Money(1100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_MONEY_UNIT.getMessage());
    }

    @DisplayName("0원이면 예외발생")
    @Test
    void zeroExceptionTest() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ZERO_EXCEPTION.getMessage());
    }

}