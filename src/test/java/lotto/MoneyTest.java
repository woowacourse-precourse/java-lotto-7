package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.validator.Money;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    void int나_long_타입이_아니면_예외를_발생한다() {
        assertThatThrownBy(() -> new Money("1000;").isNaturalNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ");

        assertThatThrownBy(() -> new Money("1_000").isNaturalNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ");

        assertThatThrownBy(() -> new Money("3.14159265").isNaturalNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ");

        assertThatThrownBy(() -> new Money("20000000000L").isNaturalNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ");

    }

}