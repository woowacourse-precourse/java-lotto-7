package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("금액이 음수일 경우 예외가 발생한다.")
    @Test
    void moneyNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Money(-1));
    }

    @DisplayName("금액이 0일 경우 예외가 발생하지 않는다.")
    @Test
    void moneyZero() {
        assertDoesNotThrow(() -> new Money(0));
    }

    @DisplayName("금액이 양수일 경우 예외가 발생하지 않는다.")
    @Test
    void moneyPositive() {
        assertDoesNotThrow(() -> new Money(1));
    }
}