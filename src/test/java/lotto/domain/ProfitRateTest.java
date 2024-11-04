package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProfitRateTest {

    @ParameterizedTest(name = "수익률 : {2}")
    @MethodSource("provideProfitRate")
    @DisplayName("수익률을 구한다.")
    void getProfitRate(int purchaseAmount, int totalPrize, double expectedRate) {
        assertThat(ProfitRate.of(purchaseAmount, totalPrize).getProfitRate()).isEqualTo(expectedRate);
    }

    private static Stream<Arguments> provideProfitRate() {
        return Stream.of(
                Arguments.of(10000, 1000, 10.0),
                Arguments.of(12000, 15000, 125.0),
                Arguments.of(100000, 5000, 5.0),
                Arguments.of(100000, 0, 0.0)
        );
    }

}