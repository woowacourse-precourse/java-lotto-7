package lotto.domain.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.rank.LottoPrice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@SuppressWarnings("NonAsciiCharacters")
class LottoStatisticsTest {

    @ParameterizedTest
    @CsvSource({
            "2000000, 1000000, 200.0",
            "0, 10000, 0.0",
            "5000, 8000, 62.5"
    })
    void 정확한_수익률을_계산한다(double totalPrice, int purchaseLotto, double returnRate) {
        // when
        double actual = LottoStatistics.calculateReturnRate(totalPrice, purchaseLotto);

        // then
        assertThat(actual).isEqualTo(returnRate);
    }

    @ParameterizedTest
    @CsvSource({
            "5000, '5,000'",
            "0, 0",
            "10000, '10,000'",
            "2000000000, '2,000,000,000'"
    })
    void 천원_단위의_형식으로_금액을_변환한다(int price, String expected) {
        // when
        String actual = LottoStatistics.makeKoreaMoneyForm(price);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideLottoPriceMappings")
    void 등수에_따라_정확한_값을_매핑한다(LottoPrice lottoPrice, int expectedCount) {
        // given
        List<Integer> sortedRanks = Arrays.asList(1, 0, 0, 1, 2);

        // when
        Map<LottoPrice, Integer> actual = LottoStatistics.makeRankToPrice(sortedRanks);

        // then
        assertThat(actual).containsEntry(lottoPrice, expectedCount);
    }

    private static Stream<Object[]> provideLottoPriceMappings() {
        return Stream.of(
                new Object[]{LottoPrice.THREE, 1},
                new Object[]{LottoPrice.FOUR, 0},
                new Object[]{LottoPrice.FIVE, 0},
                new Object[]{LottoPrice.FIVE_BONUS, 1},
                new Object[]{LottoPrice.SIX, 2}
        );
    }
}
