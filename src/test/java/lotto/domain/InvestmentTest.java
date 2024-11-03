package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import lotto.domain.lotto.Investment;
import org.junit.jupiter.api.Test;

class InvestmentTest {

    @Test
    void 초기_금액은_1000으로_나누어떨어지지_않으면_예외를_발생한다() {
        assertThatThrownBy(() -> new Investment(BigInteger.valueOf(1234)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액은_음수면_예외를_발생한다() {
        assertThatThrownBy(() -> new Investment(BigInteger.valueOf(-1))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 초기_금액은_100000_초과가_될수없다() {
        assertThatThrownBy(() -> new Investment(BigInteger.valueOf(200000)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
