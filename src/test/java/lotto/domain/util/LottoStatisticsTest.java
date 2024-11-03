package lotto.domain.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class LottoStatisticsTest {

    @ParameterizedTest
    @CsvSource({"2000000, 1000000, 200.0", "0, 10000, 0.0", "5000, 8000, 62.5"})
    void 정확한_수익률을_계산한다(double totalPrice, int purchaseLotto, double returnRate) {
        // when
        double actual = LottoStatistics.calculateReturnRate(totalPrice, purchaseLotto);

        // then
        assertThat(actual).isEqualTo(returnRate);
    }
}
