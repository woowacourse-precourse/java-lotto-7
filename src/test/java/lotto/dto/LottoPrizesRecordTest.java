package lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.LottoPrice;
import lotto.domain.LottoPrize;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoPrizesRecordTest {

    @ParameterizedTest
    @MethodSource("provideLottoPrizesForTotalEarningAmount")
    void 총_수익_금액_계산_테스트(Map<LottoPrize, Integer> lottoPrizesMap, BigDecimal expectedEarning) {
        // Given
        LottoPrizesRecord lottoPrizesRecord = new LottoPrizesRecord(lottoPrizesMap);

        // When
        BigDecimal totalEarningAmount = lottoPrizesRecord.totalEarningAmount();

        // Then
        assertThat(totalEarningAmount).isEqualTo(expectedEarning);
    }

    static Stream<Object[]> provideLottoPrizesForTotalEarningAmount() {
        return Stream.of(
                new Object[]{
                        Map.of(
                                LottoPrize.FIRST_PRIZE, 1,  // 2,000,000,000 원
                                LottoPrize.SECOND_PRIZE, 0,
                                LottoPrize.THIRD_PRIZE, 1,   // 1,500,000 원
                                LottoPrize.NO_PRIZE, 0
                        ),
                        BigDecimal.valueOf(2000000000L + 1500000L)
                },
                new Object[]{
                        Map.of(
                                LottoPrize.FIRST_PRIZE, 0,
                                LottoPrize.SECOND_PRIZE, 1,  // 30,000,000 원
                                LottoPrize.THIRD_PRIZE, 0,
                                LottoPrize.NO_PRIZE, 2       // 꽝
                        ),
                        BigDecimal.valueOf(30000000L)
                },
                new Object[]{
                        Map.of(
                                LottoPrize.FOURTH_PRIZE, 3,  // 50,000 원
                                LottoPrize.FIFTH_PRIZE, 1,   // 5,000 원
                                LottoPrize.NO_PRIZE, 0
                        ),
                        BigDecimal.valueOf(3 * 50000L + 5000L)
                }
        );
    }

    @ParameterizedTest
    @MethodSource("provideRateOfReturnTestCases")
    void 수익률_계산_테스트(Map<LottoPrize, Integer> lottoPrizesMap, LottoPrice lottoPrice, BigDecimal expectedRateOfReturn) {
        // Given
        LottoPrizesRecord lottoPrizesRecord = new LottoPrizesRecord(lottoPrizesMap);

        // When
        BigDecimal rateOfReturn = lottoPrizesRecord.getRateOfReturn(lottoPrice);
        System.out.println(rateOfReturn);
        // Then
        assertThat(rateOfReturn).isEqualByComparingTo(expectedRateOfReturn);
    }

    static Stream<Object[]> provideRateOfReturnTestCases() {
        return Stream.of(
                new Object[]{
                        Map.of(
                                LottoPrize.FIRST_PRIZE, 1,
                                LottoPrize.SECOND_PRIZE, 0,
                                LottoPrize.THIRD_PRIZE, 1,
                                LottoPrize.FOURTH_PRIZE, 1,
                                LottoPrize.FIFTH_PRIZE, 1
                        ),
                        new LottoPrice(4000), // Assume lotto price is 1000
                        BigDecimal.valueOf(50038875) // 2_001_555_000 / 4000 * 100
                },
                new Object[]{
                        Map.of(
                                LottoPrize.FIFTH_PRIZE, 2
                        ),
                        new LottoPrice(2000),
                        BigDecimal.valueOf(500.0) // 10_000 / 2_000 * 100
                },
                new Object[]{
                        Map.of(
                                LottoPrize.NO_PRIZE, 5
                        ),
                        new LottoPrice(5000),
                        BigDecimal.valueOf(0.0) // No prize case
                }
        );
    }

}