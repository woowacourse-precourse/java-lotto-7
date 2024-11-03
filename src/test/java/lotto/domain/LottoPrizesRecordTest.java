package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Stream;
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
}