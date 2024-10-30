package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PrizeCalculatorTest {
    @Test
    void 수익률_계산() {
        Assertions.assertThat(PrizeCalculator.calcRate(12000, 5000)).isEqualTo(41.7);
        Assertions.assertThat(PrizeCalculator.calcRate(8000, 5000)).isEqualTo(62.5);
    }

}
