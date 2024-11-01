package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WonTest {

    @ParameterizedTest
    @CsvSource(value = {"999,true", "1001,false"})
    void 해당금액보다_낮은_금액인지_확인(int amount, boolean result) {
        assertThat(new Won(1000).isLessThan(new Won(amount))).isEqualTo(result);
    }
}
