package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constants.Constants.FIRST_PLACE_PRIZE;
import static lotto.constants.Constants.SECOND_PLACE_PRIZE;
import static lotto.constants.Constants.PERCENTAGE_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

class ResultCalculatorTest {

    private ResultCalculator resultCalculator;

    @BeforeEach
    void setUp() {
        resultCalculator = new ResultCalculator();
    }

    @Test
    @DisplayName("등수를 기록할 때, 올바르게 rankCount와 totalPrize가 업데이트되는지 테스트")
    void 등수_기록_테스트() {
        resultCalculator.recordRank(1); // 1등
        resultCalculator.recordRank(3); // 3등
        resultCalculator.recordRank(3); // 3등
        resultCalculator.recordRank(5); // 5등

        int[] rankCount = resultCalculator.getRankCount();

        assertThat(rankCount[1]).isEqualTo(1); // 1등 1번
        assertThat(rankCount[3]).isEqualTo(2); // 3등 2번
        assertThat(rankCount[5]).isEqualTo(1); // 5등 1번
        assertThat(resultCalculator.calculateProfitRate(1000)).isGreaterThan(0); // totalPrize 검증을 간접 확인
    }

    @Test
    @DisplayName("총 소비 금액이 0이 아닌 경우 수익률이 올바르게 계산되는지 테스트")
    void calculateProfitRateTest() {
        resultCalculator.recordRank(1); // 1등 상금
        resultCalculator.recordRank(2); // 2등 상금

        int totalSpent = 2000; // 예시 소비 금액
        double expectedProfitRate = (FIRST_PLACE_PRIZE.getValue() + SECOND_PLACE_PRIZE.getValue())
                / (double) totalSpent * PERCENTAGE_NUMBER.getValue();

        assertThat(resultCalculator.calculateProfitRate(totalSpent)).isEqualTo(expectedProfitRate);
    }

    @Test
    @DisplayName("등수가 기록되지 않은 경우 수익률이 0인지 테스트")
    void calculateProfitRateWithoutRanksTest() {
        int totalSpent = 1000; // 예시 소비 금액
        double profitRate = resultCalculator.calculateProfitRate(totalSpent);

        assertThat(profitRate).isEqualTo(0.0);
    }
}