package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("금액을 음수로 입력하면 예외를 발생시킨다.")
    @Test
    void validatePositive() {
        assertThatThrownBy(() -> new Money(BigDecimal.valueOf(-1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 금액이 1000원으로 나누어 떨어지지 않으면 예외를 발생시킨다.")
    @Test
    void validateUnit() {
        assertThatThrownBy(() -> new Money(BigDecimal.valueOf(1001)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
